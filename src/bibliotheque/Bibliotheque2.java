package bibliotheque;

import java.util.ArrayList;

public class Bibliotheque2 {

	private ArrayList<Livre> fonds;
	private ArrayList<Abonne> abonnes;
	private ArrayList<Emprunt> emprunts;
	private ArrayList<Auteur> auteurs;
	
	public Bibliotheque2() {
		super();
	}

	public ArrayList<Livre> getFonds() {
		return fonds;
	}

	public void setFonds(ArrayList<Livre> fonds) {
		this.fonds = fonds;
	}

	public ArrayList<Abonne> getAbonnes() {
		return abonnes;
	}

	public void setAbonnes(ArrayList<Abonne> abonnes) {
		this.abonnes = abonnes;
	}

	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public ArrayList<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(ArrayList<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	
	
}
