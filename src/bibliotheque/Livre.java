package bibliotheque;

import java.time.LocalDate;

public class Livre {

	private String ident; 
    private String titre; 
    private LocalDate date_Parution;
    private Auteur auteur;
    private String ISBN;
    
	private String idExemplaire;
	
    
    public Livre() {
		super();
	}
	
    
    public Livre(String titre, LocalDate date_Parution, Auteur auteur, String iSBN, String id_Exemplaire) {
		super();
		this.titre = titre;
		this.date_Parution = date_Parution;
		this.auteur = auteur;
		ISBN = iSBN;
		this.idExemplaire = id_Exemplaire;
	}
	
    // ----------------------------------------------------------
public void affiche() {
	
    System.out.println("--------------------------- Livre ---"); 
    System.out.println("Voici le titre du Livre : " + this.titre);
    System.out.println("Voici la Date de Parution : " + this.date_Parution);
    System.out.println("Voici l'ISBN du Livre : " + this.ISBN);
    System.out.println("Voici le numéro d'exemplaire du Livre : " + this.idExemplaire);
    this.auteur.affiche();
   

}
    

    // ----------------------------------------------------------
    

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public LocalDate getDate_Parution() {
		return date_Parution;
	}
	public void setDate_Parution(LocalDate date_Parution) {
		this.date_Parution = date_Parution;
	}
	public Auteur getAuteur() {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getExemplaires() {
		return this.idExemplaire;
	}
	public void setIdExemplaires(String idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	
	public String getIdent() {
		return ident;
	}


	public void setIdent(String ident) {
		this.ident = ident;
	}



    
}
