package Model;

import java.awt.List;

public class Customers {

	private String cid;
	private String name;
	private String city;
	private int discnt;
	
	private List commandes;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getDiscnt() {
		return discnt;
	}
	public void setDiscnt(int discnt) {
		this.discnt = discnt;
	}
	
	
	
}
