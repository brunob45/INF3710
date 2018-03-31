package Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chercheur")
public class Chercheur {

	@Id
	@Column(name="matricule")
	private String matricule;

	@Column(name ="prenom")
	private String prenom;
	@Column(name="nom")
	private String nom;
	@Column(name="position")
	private String position;
	@Column(name="salaire")
	private Integer salaire;
	@ManyToOne
	@JoinColumn(name="equipe")
	private Equipe equipe;
	
	@OneToMany (targetEntity=Article.class,
			mappedBy="auteur",
			fetch=FetchType.LAZY, 
			cascade=CascadeType.ALL)
	private List<Article> articles;

	@Override
	public String toString() {
		return getMatricule() + ", " + getPrenom() + ", " + getNom() + ", " + getPosition() + ", " + getSalaire() + ", " + getEquipe().getNom();
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

	public Integer getSalaire() {
		return salaire;
	}

	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
