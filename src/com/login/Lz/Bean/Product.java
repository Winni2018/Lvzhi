package com.login.Lz.Bean;

public class Product {
	private int proId;
	private String proName;
	private float proPrice;
	private String proInfo;
	private String proPic;
	private String proDetails;
	private int proClassId;
	private Proclass proclass;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public float getProPrice() {
		return proPrice;
	}
	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}
	public String getProInfo() {
		return proInfo;
	}
	public void setProInfo(String proInfo) {
		this.proInfo = proInfo;
	}
	public String getProPic() {
		return proPic;
	}
	public void setProPic(String proPic) {
		this.proPic = proPic;
	}
	public int getProClassId() {
		return proClassId;
	}
	public void setProClassId(int proClassId) {
		this.proClassId = proClassId;
	}
	public Proclass getProclass() {
		return proclass;
	}
	public void setProclass(Proclass proclass) {
		this.proclass = proclass;
	}
	public String getProDetails() {
		return proDetails;
	}
	public void setProDetails(String proDetails) {
		this.proDetails = proDetails;
	}


}
