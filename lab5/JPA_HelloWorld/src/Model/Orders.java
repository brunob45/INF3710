package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	private int ordno;
	@Column(name="month")
	private String mois;
	
	private int qty;
	private int dollars;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Customers c;
	
	
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
	public Customers getC() {
		return c;
	}
	public void setC(Customers c) {
		this.c = c;
	}

}
