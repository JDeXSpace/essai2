package bibliotheque;

import java.util.Arrays;

public class Bibliotheque {

	private Livre[] fonds;
	private Abonne[] abonnes;
	
	private Emprunt[] emprunts;
	private Auteur[] auteurs;
	
	public Bibliotheque() {
		super();
	}

	@Override
	public String toString() {
		return "Bibliotheque [fonds=" + Arrays.toString(fonds) + ", abonnes=" + Arrays.toString(abonnes) + ", emprunts="
				+ Arrays.toString(emprunts) + ", auteurs=" + Arrays.toString(auteurs) + "]";
	}
	
	public void affiche() {}

	
	// getters et setters
	
	public Livre[] getFonds() {
		return fonds;
	}
	
	public void setFonds(Livre[] fonds) {
		this.fonds = fonds;
	}

	public Abonne[] getAbonnes() {
		return abonnes;
	}

	public void setAbonnes(Abonne[] abonnes) {
		this.abonnes = abonnes;
	}

	public Emprunt[] getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Emprunt[] emprunts) {
		this.emprunts = emprunts;
	}

	public Auteur[] getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Auteur[] auteurs) {
		this.auteurs = auteurs;
	}


}
