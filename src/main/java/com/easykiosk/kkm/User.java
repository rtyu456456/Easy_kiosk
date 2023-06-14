package com.easykiosk.kkm;

public class User {
	private String phoneNumber;
	private int point;
	private int finalPrice;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String phoneNumber, int point, int finalPrice) {
		super();
		this.phoneNumber = phoneNumber;
		this.point = point;
		this.finalPrice = finalPrice;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", point=" + point + ", finalPrice=" + finalPrice + "]";
	}
	
	
	
	
	
	
	
}
