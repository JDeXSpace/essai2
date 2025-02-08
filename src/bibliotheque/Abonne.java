package bibliotheque;


import java.time.LocalDate;


public class Abonne {

	private String nom;
	private String prenom;
	private String code;
	private String login;
	private String password;
	private String adresse;
	private String email;
	private LocalDate inscription;
	private LocalDate penalite;

	public Abonne() { }

	
	public Abonne(String nom, String prenom, String code, String login, String password, String adresse, String email,
			LocalDate inscription, LocalDate penalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.code = code;
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.email = email;
		this.inscription = inscription;
		this.penalite = penalite;
	}

	
	
	@Override
	public String toString() {
		return "Abonne [nom=" + nom + ", prenom=" + prenom + ", code=" + code + ", login=" + login + ", password="
				+ password + ",\n adresse=" + adresse + ", email=" + email + ", inscription=" + inscription
				+ ", penalite=" + penalite + "]";
	}

	
	public void print() {
		System.out.println(this.toString());
	}
	
	public void affiche() {
		System.out.println("-------------------------------------------------- ");
		System.out.println("Nom de l'abonné : "+ this.nom);
		System.out.println("Prénom de l'abonné : "+ this.prenom);
		System.out.println("Adresse de l'abonné : "+ this.adresse);
		System.out.println("Email de l'abonné : "+ this.email);
		System.out.println("Date de dernière inscription l'abonné : "+ this.inscription);
		if (this.penalite != null)
		System.out.println("Cet abonné est puni jusqu'au : "+ this.penalite);
	}

	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getInscription() {
		return inscription;
	}

	public void setInscription(LocalDate inscription) {
		this.inscription = inscription;
	}

	public LocalDate getPenalite() {
		return penalite;
	}

	public void setPenalite(LocalDate penalite) {
		this.penalite = penalite;
	}

}
