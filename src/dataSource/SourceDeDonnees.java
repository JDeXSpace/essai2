package dataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SourceDeDonnees {

	private Connection cnx;
	private static SourceDeDonnees sdd;

	private String Driver;
	private String url;
	String password;
	String login;

	private SourceDeDonnees(String driver, String url, String login, String password) {

		Driver = driver;
		this.url = url; // avec la Base
		this.password = password;
		this.login = login;
		this.doConnection();
	}

	public static SourceDeDonnees getSourceDeDonnees(String driver, String url, String login, String password) {
		if (SourceDeDonnees.sdd == null)
			SourceDeDonnees.sdd = new SourceDeDonnees(driver, url, login, password);
		return SourceDeDonnees.sdd;
	}

	public Connection getCnx() {
		return cnx;
	}

	public void setCnx(Connection cnx) {
		this.cnx = cnx;
	}

	// créer la connexion en affectant cnx
	// le booleen retourné indique si la connexion s'est bien passée ou non
	public boolean doConnection() {
		boolean connexionReussie = false;
		// parametre url = "jdbc:mariadb://localhost:3306/bibliotheque";
		// parametre driver = "org.mariadb.jdbc.Driver"
		try {
			if ((this.cnx != null) && (this.cnx.isValid(5)))
				connexionReussie = true;
			else {
				Class.forName(Driver);

				System.out.println("On demande une connexion sur url: " + this.url);
				System.out.println("On demande une connexion sur login: " + this.login);
				System.out.println("On demande une connexion sur password: " + this.password);

				this.cnx = DriverManager.getConnection(this.url, this.login, this.password);
				connexionReussie = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connexionReussie;
	}

// méthode pour un DAO. Elle est capable de lancer des requêtes en select
	public ResultSet doSearch(String requete) // requete de type Select
	{
		ResultSet rst = null;
		Statement stmt;

		try {
			stmt = cnx.createStatement();
			System.out.println("La requete envoyée : " + requete);
			rst = stmt.executeQuery(requete);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans l'exécution de la requète");
		}
		return rst;

	} // fin de la fonction doSearch()

	public int doAdd(String requete) {
		int ret = 0;
		Statement stmt;
		System.out.println("On va lancer la requete : ");

		try {
			stmt = cnx.createStatement();
			ret = stmt.executeUpdate(requete);
			System.out.println("Nombre de tuples effectivement modifiés : " + ret);
			return ret;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans l'exécution de la requète en update");
			return ret;
		}

	}

	/*
	 * Statement 	
	 */

	//permet de faire des modifs en BD et se trouve "sensible" aux modifs. faites en BD 
		public Statement doStmtUpdatable() {
			Statement ustmt = null;
			try {
				ustmt = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return ustmt;
		}

	
	// méthode qui retourne un Statement (objet qui permet d'envoyer des requetes)
	// sensible aux modification faites dans le resultSet ou dans la BD
	public Statement doSensibleStatement() {
		// il se crée à partir de l'objet connexion
		Statement stmt = null;

		try {
			stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			return stmt;
		} catch (SQLException e) {
			e.printStackTrace();
			return stmt;
		}
	}

	public ResultSet doSearchSensible(String requete) {
		ResultSet result = null;

		try {
			Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			System.out.println("Requete demandée en SensibleSearch : " + requete);
			result = stmt.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	/*
	 * méthode pour l'execution d'une requête inconnue
	 */

	public boolean doExec(String requete, Object[] retours) {
		Statement stmt;
		ResultSet rs =null;
		boolean rsCheck = false;
		//retours = new Object[2];

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + requete);
		try {
			stmt = cnx.createStatement();

			rsCheck = stmt.execute(requete);

			if (!rsCheck) {
				// c'est une requete en update : affichage du résultat
				retours[0] = stmt.getUpdateCount();
				//System.out.println("la requete " + requete + " a bien été exécutée");
				//System.out.println("le nombre de ligne modifiée est : " + rowCount);
			} else 
				// c'est une requete en Select : affichage du résultat
				rs = stmt.getResultSet();
				retours[1]=rs;
				if (retours[1]==null) System.err.println("ATTENTION RS est null !!!!!!!!!!!!!!!!!!!!!!!!");
				
				
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans l'exécution de la requète");
		}
		return rsCheck;
	}
	



/*
 * Requètes précompilées	
 */
	public PreparedStatement getPreparedStatement(String req) {
		PreparedStatement ps = null;

		try {
			ps = cnx.prepareStatement(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}


/*
 * MetaData
 */
	
	public DatabaseMetaData getMetaDonnees() {
		DatabaseMetaData metaDonnees=null;
		try {
			 metaDonnees = this.cnx.getMetaData();
		} catch (SQLException e) {
			System.out.println("Dans le donne infos sur BD " + e.toString());
		}
		return metaDonnees;
	}
	


/*
 * batch
 */
	
	public void doBatch(String[] lotReq) {

		Statement stmt = null;
		try {
			stmt = cnx.createStatement();

			for (String requete : lotReq) {

				System.out.println("Requete ajoutée au lot : " + requete);
				stmt.addBatch(requete);
			}

			stmt.executeBatch();
		} catch (

		SQLException ex) {
			System.out.println("SQLException: " + ex);
		}
	}
	

	/*
	 *  Isolation
	 */
	public int getNiveauIsolation()
	{
		int isolationLvel=-1;
		try {
			isolationLvel = getCnx().getTransactionIsolation();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isolationLvel;
	}
	
	// essai d'un rollback après plusieurs ajouts
	public void faitTransacEnModif(String modif) {
		Scanner sc = new Scanner("System.in");

		try {
			cnx.setAutoCommit(false); // on est passé en validation manuelle

			this.doAdd(modif); // on ajoute 6 exemplaires

			System.out.println(">>> Avant la levée de l'exception <<< ");
			int i = sc.nextInt(); // on stoppe avant la levée de l'exception
			// si on saisit une lettre cela va générer une exception

			cnx.commit();
			cnx.setAutoCommit(true);
		} catch (Exception e4) {
			System.out.println("Dans le catch " + e4);
			sc.next();
			try {
				cnx.rollback();
				System.out.println("on passe dans le Rollback");
			} // annulation totale
			catch (Exception e5) {
				System.out.println("Dans le 5 " + e5.getMessage());
			}
		} finally {
			try {
				cnx.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}





}
