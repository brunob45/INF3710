package Model;

public class Commande {
	
	private int ordno;
	private String mois;
	private int qty;
	private int dollars;
	
	private Client c;
	
	public int getOrdno() {
		return ordno;
	}
	public void setOrdno(int ordno) {
		this.ordno = ordno;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDollars() {
		return dollars;
	}
	public void setDollars(int dollars) {
		this.dollars = dollars;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	
	

}
