package application;
public class Livre {
	private int NumLivre;
	private String Titre;
	private String Auteur;
	private int Etat;
	private String Categorie;
	public Livre(int numLivre, String titre, String auteur, int etat, String categorie) {
		super();
		NumLivre = numLivre;
		Titre = titre;
		Auteur = auteur;
		Etat = etat;
		this.Categorie = categorie;
	}
	public int getNumLivre() {
		return NumLivre;
	}
	public void setNumLivre(int numLivre) {
		NumLivre = numLivre;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public int getEtat() {
		return Etat;
	}
	public void setEtat(int etat) {
		Etat = etat;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		this.Categorie = categorie;
	}
	

	
	
	


}
