package bibliotheque;

import java.time.LocalDate;

public class Auteur {

	private String nom;
	private String prenom;
	private LocalDate ddn;
	private LocalDate ddd;

// constructeurs	
	public Auteur(String nom, String prenom, LocalDate ddn, LocalDate ddd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.ddn = ddn;
		this.ddd = ddd;
	}

	public Auteur() {
		super();
	}

	public void affiche() {

		System.out.println("--------------------------- Auteur ---");
		System.out.println("Voici le nom de l'auteur : " + this.nom);
		System.out.println("Voici la prénom de l'auteur : " + this.prenom);
		System.out.println("Voici sa date de naissance : " + this.ddn);
		System.out.println("Voici sa date de naissance : " + this.ddd);
	}

	// getters and Setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public LocalDate getDdd() {
		return ddd;
	}

	public void setDdd(LocalDate ddd) {
		this.ddd = ddd;
	}

}
