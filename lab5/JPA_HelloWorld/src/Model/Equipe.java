package Model;

import java.sql.Date;
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
import javax.persistence.Transient;
import javax.persistence.criteria.Order;

@Entity
@Table(name="equipe")
public class Equipe {

	@Id
	@Column(name="nom")
	private String nom;

	@Column(name ="dateCreation")
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="departement")
	private Departement departement;
	@Column(name="responsable")
	private String responsable;
	@Column(name="nbrProjets")
	private Integer nbrProjets;
	
	@OneToMany (targetEntity=Chercheur.class,
			mappedBy="equipe",
			fetch=FetchType.LAZY, 
			cascade=CascadeType.ALL)
	private List<Chercheur> chercheurs;

	@Override
	public String toString() {
		return getNom() + ", " + getDateCreation() + ", " + getDepartement().getNom() + ", " + getResponsable() + ", " + getNbrProjets();
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
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

	public List<Chercheur> getChercheurs() {
		return chercheurs;
	}

	public void setChercheurs(List<Chercheur> chercheurs) {
		this.chercheurs = chercheurs;
	}
}
