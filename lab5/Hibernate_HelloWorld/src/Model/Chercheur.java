package Model;

import java.util.Set;

import javax.persistence.Column;

public class Chercheur {
	private String matricule;
	private String prenom;
	private String nom;
	private String position;

	@Column(insertable=false, updatable=false)
	private Equipe equipe;
	
	private int salaire;
	
	private Set<Article> articles;
	
	public Chercheur(String matricule, String prenom, String nom,
			String position, Equipe equipe, int salaire) {
		this.setMatricule(matricule);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setPosition(position);
		this.setEquipe(equipe);
		this.setSalaire(salaire);
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
}
