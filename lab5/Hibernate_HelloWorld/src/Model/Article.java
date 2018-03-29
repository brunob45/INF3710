package Model;

public class Article {
	private String auteur;
	private String coauteur;
	private String soumisLe;
	private String departement;
	
	public Article() {}
	
	public Article(String auteur, String coauteur, String soumisLe, String departement) {
		this.setAuteur(auteur);
		this.setCoauteur(coauteur);
		this.setSoumisLe(soumisLe);
		this.setDepartement(departement);
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getCoauteur() {
		return coauteur;
	}

	public void setCoauteur(String coauteur) {
		this.coauteur = coauteur;
	}

	public String getSoumisLe() {
		return soumisLe;
	}

	public void setSoumisLe(String soumisLe) {
		this.soumisLe = soumisLe;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	
}
