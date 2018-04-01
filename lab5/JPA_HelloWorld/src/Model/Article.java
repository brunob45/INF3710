package Model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
@IdClass(Article.PK.class)
public class Article {
	public static class PK implements Serializable {
		private Chercheur auteur;
		private LocalDate soumisLe;
		private Departement departement;
		
		@Override
		public boolean equals(Object o) {
			if(o.getClass() == PK.class) {
				PK pk = (PK)o;
				return this.auteur.equals(pk.auteur) 
					&& this.soumisLe.equals(pk.soumisLe) 
					&& this.departement.equals(pk.departement);
			}
			return false;
		}
		@Override
		public int hashCode() {
			return this.auteur.hashCode() ^ this.soumisLe.hashCode() ^ this.departement.hashCode();
		}
	}

	@Id
	@ManyToOne
	@JoinColumn(name ="auteur", referencedColumnName="matricule")
	private Chercheur auteur;
	@ManyToOne
	@JoinColumn(name ="coauteur", referencedColumnName="matricule")
	private Chercheur coauteur;
	@Id
	@Column(name="soumisLe")
	private LocalDate soumisLe;
	@Id
	@ManyToOne
	@JoinColumn(name ="departement", referencedColumnName="nom")
	private Departement departement;
	

	@Override
	public String toString() {
		if(getCoauteur() == null) {
			return getAuteur().getMatricule() + ", " + getSoumisLe() + ", " + getDepartement().getNom();
		} else {
			return getAuteur().getMatricule() + ", " + getCoauteur().getMatricule() + ", "+ getSoumisLe() + ", " + getDepartement().getNom();
		}
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


	public LocalDate getSoumisLe() {
		return soumisLe;
	}


	public void setSoumisLe(LocalDate soumisLe) {
		this.soumisLe = soumisLe;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
}
