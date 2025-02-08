package application;

import bibliotheque.*;
import dataSource.SourceDeDonnees;

//import facade.Facade_Biblio;

public class ApplicationMetier {

//	Facade_Biblio guichet;
	
		
	public ApplicationMetier() {
		super();
//		this.guichet = new Facade_Biblio();		// creation de la facade
		// qui crée la source de données
		// crée et initialise les DAO
		// qui se connecte à la BD
	}

/*
	public void afficheMoiLesAuteursQuiOntCeCode(String code) {
	 
		Auteur a = guichet.getAuteurById(code); 
		a.affiche();
	}

	public void afficheMoiLesAuteursQuiOntCeNom(String nom) {
		 
		Auteur[] allAuteurs = guichet.getAuteursByName(nom); 
		for (Auteur auteur : allAuteurs) {
			auteur.affiche();
		}
			}
	
	public void quickSearchLivreByTitre(String motDuTitre) {
		
		Livre[] lesReponses = guichet.getAllLivresEnPrecompilee(motDuTitre);
		for (Livre livre : lesReponses) {
			livre.affiche();
		}
	}

	*/
	public static void main(String[] args) {
		
		ApplicationMetier monApplication = new ApplicationMetier();
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/Bibliotheque";
		String login = "root";
		String password = "";
		SourceDeDonnees sd = SourceDeDonnees.getSourceDeDonnees(driver, url, login, password);
		
		sd.doConnection();
		//monApplication.afficheMoiLesAuteursQuiOntCeNom("Levy");
		
		//monApplication.afficheMoiLesAuteursQuiOntCeCode(4);
		
		//monApplication.afficheLesAuteursQuiOntCeNom("Hugo");
		
		/*monApplication.inscrire("Vador",
									"Dark", 
									"darkor",
									"dd45", 
									"d.v@empire.com", 
									"Apt 2 15eme etage BlackStar");*/
		
		
		// monApplication.quickSearchLivreByTitre("La");
		
		//monApplication.guichet.Donne_InfosSurBD();
		
		//monApplication.guichet.executeTout("SELECT * FROM livres");
		
	}
	
	

}
