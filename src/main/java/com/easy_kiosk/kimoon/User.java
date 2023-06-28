package com.easy_kiosk.kimoon;

public class User {
	private String phoneNumber; // 전화번호
	private int savingPoint; // 현재 포인트
	private int usedPoint; // 사용 포인트
	private int remainPoint; // 남은 포인트
	private int totalPrice; // 총 구매가격
	private int finalPrice; // 최종 결제가격
	private int totalCnt;
	private String productName;
	private int productPrice;
	private String option_size;
	private String option_iceOrHot;
	private String option_shot;
	private String option_syrup;
	private String option_cream;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String phoneNumber, int savingPoint, int usedPoint, int remainPoint, int totalPrice, int finalPrice,
			int totalCnt, String productName, int productPrice, String option_size, String option_iceOrHot,
			String option_shot, String option_syrup, String option_cream) {
		super();
		this.phoneNumber = phoneNumber;
		this.savingPoint = savingPoint;
		this.usedPoint = usedPoint;
		this.remainPoint = remainPoint;
		this.totalPrice = totalPrice;
		this.finalPrice = finalPrice;
		this.totalCnt = totalCnt;
		this.productName = productName;
		this.productPrice = productPrice;
		this.option_size = option_size;
		this.option_iceOrHot = option_iceOrHot;
		this.option_shot = option_shot;
		this.option_syrup = option_syrup;
		this.option_cream = option_cream;
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

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getOption_size() {
		return option_size;
	}

	public void setOption_size(String option_size) {
		this.option_size = option_size;
	}

	public String getOption_iceOrHot() {
		return option_iceOrHot;
	}

	public void setOption_iceOrHot(String option_iceOrHot) {
		this.option_iceOrHot = option_iceOrHot;
	}

	public String getOption_shot() {
		return option_shot;
	}

	public void setOption_shot(String option_shot) {
		this.option_shot = option_shot;
	}

	public String getOption_syrup() {
		return option_syrup;
	}

	public void setOption_syrup(String option_syrup) {
		this.option_syrup = option_syrup;
	}

	public String getOption_cream() {
		return option_cream;
	}

	public void setOption_cream(String option_cream) {
		this.option_cream = option_cream;
	}

	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", savingPoint=" + savingPoint + ", usedPoint=" + usedPoint
				+ ", remainPoint=" + remainPoint + ", totalPrice=" + totalPrice + ", finalPrice=" + finalPrice
				+ ", totalCnt=" + totalCnt + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", option_size=" + option_size + ", option_iceOrHot=" + option_iceOrHot + ", option_shot="
				+ option_shot + ", option_syrup=" + option_syrup + ", option_cream=" + option_cream + "]";
	}
	
	
}
