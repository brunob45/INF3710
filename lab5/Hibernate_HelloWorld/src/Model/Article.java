package Model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Article implements Serializable {
	private Chercheur auteur;
	private Chercheur coauteur;
	private Date soumisLe;
	private Departement departement;

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
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() == this.getClass()) {
			Article a = (Article)o;
			return this.auteur.equals(a.auteur) && this.soumisLe.equals(a.soumisLe) && this.departement.equals(a.departement);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.auteur.hashCode() ^ this.soumisLe.hashCode() ^ this.departement.hashCode();
	}
	
	@Override
	public String toString() {
		if(this.coauteur == null) {
			return this.auteur.getMatricule() + ", " + this.soumisLe.toString() + ", " + this.departement.getNom();
		} else {
			return this.auteur.getMatricule() + ", " + this.coauteur.getMatricule() + ", " + this.soumisLe.toString() + ", " + this.departement.getNom();
		}
	}
}
