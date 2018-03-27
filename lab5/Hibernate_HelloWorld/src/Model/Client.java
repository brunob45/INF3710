package Model;

import java.util.Set;

public class Client {
	
	private String id;
	private String nom;
	private String ville;
	private int discnt;
	
	private Set<Commande> commandes;
	
	
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
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
