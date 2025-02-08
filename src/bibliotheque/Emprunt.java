package bibliotheque;

import java.time.LocalDate;

public class Emprunt {

	private Abonne emprunteur; 
	private Livre leLivre;
	private String exemplaire;
	private LocalDate date_Sortie;
	private LocalDate date_Retour;
	private LocalDate date_Rendu;
	
	public Emprunt(Abonne emprunteur, Livre leLivre, String exemplaire, LocalDate date_Sortie, LocalDate date_Retour,
			LocalDate date_Rendu) {
		super();
		this.emprunteur = emprunteur;
		this.leLivre = leLivre;
		this.exemplaire = exemplaire;
		this.date_Sortie = date_Sortie;
		this.date_Retour = date_Retour;
		this.date_Rendu = date_Rendu;
	}
	public Emprunt() {
		super();
	}
	@Override
	public String toString() {
		return "Emprunt [emprunteur=" + emprunteur + ", leLivre=" + leLivre + ", exemplaire=" + exemplaire
				+ ", date_Sortie=" + date_Sortie + ", date_Retour=" + date_Retour + ", date_Rendu=" + date_Rendu + "]";
	}
	
	public void print() {
		System.out.println(this);
	}
	
	
	public void affiche() {
		System.out.println("Voici le Livre emprunté : " + this.leLivre.getTitre());
		System.out.println("Voici l'abonné emprunteur : " + this.emprunteur.getNom());
		System.out.println("Voici la Date d'emprunt : " + this.getDate_Sortie());
		System.out.println("Voici la Date de retour attendue : " + this.getDate_Retour());
		if (this.getDate_Retour()==null) {
			System.out.println("On attend son retour");
		}
		else {
			System.out.println("Voici la date à laquelle il a été rendu : " + this.getDate_Rendu());
		}
	}
	
	
	public Abonne getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(Abonne emprunteur) {
		this.emprunteur = emprunteur;
	}
	public Livre getLeLivre() {
		return leLivre;
	}
	public void setLeLivre(Livre leLivre) {
		this.leLivre = leLivre;
	}
	public String getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(String exemplaire) {
		this.exemplaire = exemplaire;
	}
	public LocalDate getDate_Sortie() {
		return date_Sortie;
	}
	public void setDate_Sortie(LocalDate date_Sortie) {
		this.date_Sortie = date_Sortie;
	}
	public LocalDate getDate_Retour() {
		return date_Retour;
	}
	public void setDate_Retour(LocalDate date_Retour) {
		this.date_Retour = date_Retour;
	}
	public LocalDate getDate_Rendu() {
		return date_Rendu;
	}
	public void setDate_Rendu(LocalDate date_Rendu) {
		this.date_Rendu = date_Rendu;
	}
	
	
	
}
