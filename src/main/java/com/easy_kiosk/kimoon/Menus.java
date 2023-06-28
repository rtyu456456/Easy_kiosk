package com.easy_kiosk.kimoon;

public class Menus {
	private int cnt;
	private int unitPrice;
	private String name;
	private String optionSize;
	private String iceOrHot;
	private String shot;
	private String syrup;
	private String cream;
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public Menus(int cnt, int unitPrice, String name, String optionSize, String iceOrHot, String shot, String syrup,
			String cream) {
		super();
		this.cnt = cnt;
		this.unitPrice = unitPrice;
		this.name = name;
		this.optionSize = optionSize;
		this.iceOrHot = iceOrHot;
		this.shot = shot;
		this.syrup = syrup;
		this.cream = cream;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptionSize() {
		return optionSize;
	}

	public void setOptionSize(String optionSize) {
		this.optionSize = optionSize;
	}

	public String getIceOrHot() {
		return iceOrHot;
	}

	public void setIceOrHot(String iceOrHot) {
		this.iceOrHot = iceOrHot;
	}

	public String getShot() {
		return shot;
	}

	public void setShot(String shot) {
		this.shot = shot;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public String getCream() {
		return cream;
	}

	public void setCream(String cream) {
		this.cream = cream;
	}

	@Override
	public String toString() {
		return "menus [cnt=" + cnt + ", unitPrice=" + unitPrice + ", name=" + name + ", optionSize=" + optionSize
				+ ", iceOrHot=" + iceOrHot + ", shot=" + shot + ", syrup=" + syrup + ", cream=" + cream + "]";
	}
	
}	