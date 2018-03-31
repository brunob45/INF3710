package Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.Order;

@Entity
@Table(name="departement")
public class Departement {

	@Id
	@Column(name="nom")
	private String nom;

	@Column(name ="dateCreation")
	private Date dateCreation;
	@Column(name="adresse")
	private String adresse;
	@Column(name="telephone")
	private String telephone;
	
	@OneToMany (targetEntity=Equipe.class,
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY, 
			mappedBy="departement")
	private List<Equipe> equipes;
	@OneToMany (targetEntity=Article.class,
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY, 
			mappedBy="departement")
	private List<Article> articles;

	@Override
	public String toString() {
		return getNom() + ", " + getDateCreation() + ", " + getAdresse() + ", " + getTelephone();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
