package com.easy_kiosk.kimoon;

public class User {
	private String phoneNumber; // 전화번호
	private int savingPoint; // 현재 포인트
	private int usedPoint; // 사용 포인트
	private int remainPoint; // 남은 포인트
	private int totalPrice; // 총 구매가격
	private int finalPrice; // 최종 결제가격
	private int cnt;
	private int unitPrice;
	private String name;
	private String optionSize;
	private String iceOrHot;
	private String shot;
	private String syrup;
	private String cream;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String phoneNumber, int savingPoint, int usedPoint, int remainPoint, int totalPrice, int finalPrice,
			int cnt, int unitPrice, String name, String optionSize, String iceOrHot, String shot, String syrup,
			String cream) {
		super();
		this.phoneNumber = phoneNumber;
		this.savingPoint = savingPoint;
		this.usedPoint = usedPoint;
		this.remainPoint = remainPoint;
		this.totalPrice = totalPrice;
		this.finalPrice = finalPrice;
		this.cnt = cnt;
		this.unitPrice = unitPrice;
		this.name = name;
		this.optionSize = optionSize;
		this.iceOrHot = iceOrHot;
		this.shot = shot;
		this.syrup = syrup;
		this.cream = cream;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSavingPoint() {
		return savingPoint;
	}

	public void setSavingPoint(int savingPoint) {
		this.savingPoint = savingPoint;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}

	public int getRemainPoint() {
		return remainPoint;
	}

	public void setRemainPoint(int remainPoint) {
		this.remainPoint = remainPoint;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
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
		return "User [phoneNumber=" + phoneNumber + ", savingPoint=" + savingPoint + ", usedPoint=" + usedPoint
				+ ", remainPoint=" + remainPoint + ", totalPrice=" + totalPrice + ", finalPrice=" + finalPrice
				+ ", cnt=" + cnt + ", unitPrice=" + unitPrice + ", name=" + name + ", optionSize=" + optionSize
				+ ", iceOrHot=" + iceOrHot + ", shot=" + shot + ", syrup=" + syrup + ", cream=" + cream + "]";
	}
	
	

}
