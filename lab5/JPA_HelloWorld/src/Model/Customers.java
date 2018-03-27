package Model;

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
@Table(name="customers")
public class Customers {

	@Id
	@Column(name="cid")
	private String id;

	@Column(name ="cname")
	private String nom;
	@Column(name="city")
	private String ville;

	private int discnt;

	@Transient
	private int age;
	
	@OneToMany (targetEntity=Orders.class,
			cascade=CascadeType.ALL,
			// LAZY ou EAGER
			fetch=FetchType.LAZY, 
			mappedBy="c")
	private List<Orders> commandes;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getDiscnt() {
		return discnt;
	}
	public void setDiscnt(int discnt) {
		this.discnt = discnt;
	}
	public List<Orders> getCommandes() {
		return this.commandes;
	}
	public void setCommandes(List<Orders> c) {
		this.commandes = c;
	}
	@Override
	public String toString() {
		return id + "," + nom + "," + ville + "," + discnt;
	}
}
