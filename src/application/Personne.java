package application;

public class Personne {
	int NumPersonne;
	String Prenom;
	String Nom;
	String Adresse;
	String Telephone;
	
	public Personne(int numPersonne, String prenom, String nom, String adresse, String telephone) {
		super();
		NumPersonne = numPersonne;
		Prenom = prenom;
		Nom = nom;
		Adresse = adresse;
		Telephone = telephone;
	}

	public int getNumPersonne() {
		return NumPersonne;
	}

	public void setNumPersonne(int numPersonne) {
		NumPersonne = numPersonne;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	

}
