package Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

public class Article implements Serializable {

	private Chercheur auteur;

//	@Column(insertable=false, updatable=false)
	private Chercheur coauteur;
	
	private Date soumisLe;
	private Departement departement;
	
	public Article() {}
	
	public Article(Chercheur auteur, Chercheur coauteur, Date soumisLe, Departement departement) {
		this.setAuteur(auteur);
		this.setCoauteur(coauteur);
		this.setSoumisLe(soumisLe);
		this.setDepartement(departement);
	}

	public Chercheur getAuteur() {
		return auteur;
	}

	public void setAuteur(Chercheur auteur) {
		this.auteur = auteur;
	}

	public Chercheur getCoauteur() {
		return coauteur;
	}

	public void setCoauteur(Chercheur coauteur) {
		this.coauteur = coauteur;
	}

	public Date getSoumisLe() {
		return soumisLe;
	}

	public void setSoumisLe(Date soumisLe) {
		this.soumisLe = soumisLe;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public boolean equals(Object o) {
		if(o.getClass() == this.getClass()) {
			Article a = (Article)o;
			return this.auteur.equals(a.auteur) && this.soumisLe.equals(a.soumisLe) && this.departement.equals(a.departement);
		}
		return false;
	}
	
	public int hashCode() {
		return this.auteur.hashCode() ^ this.soumisLe.hashCode() ^ this.departement.hashCode();
	}
	
}
