package Model;

import java.sql.Date;
import java.util.Set;

public class Equipe {
	private String nom;
	private Date dateCreation;
	private String responsable;
	private Integer nbrProjets;
	private Departement departement;
	
	private Set<Chercheur> chercheurs;

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

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Integer getNbrProjets() {
		return nbrProjets;
	}

	public void setNbrProjets(Integer nbrProjets) {
		this.nbrProjets = nbrProjets;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<Chercheur> getChercheurs() {
		return chercheurs;
	}

	public void setChercheurs(Set<Chercheur> chercheurs) {
		this.chercheurs = chercheurs;
	}
	
	@Override
	public String toString() {
		return this.nom + ", " + this.dateCreation.toString() + ", " + this.responsable + ", " + this.nbrProjets + ", " + this.departement;
	}
}
