package com.easy_kiosk.kimoon;

public class User {
	private String phoneNumber; // 전화번호
	private int savingPoint; // 현재 포인트
	private int usedPoint; // 사용 포인트
	private int remainPoint; // 남은 포인트
	private int totalPrice; // 총 구매가격
	private int finalPrice; // 최종 결제가격
	
	public User() {
	}

	public User(String phoneNumber, int savingPoint, int usedPoint, int remainPoint, int totalPrice, int finalPrice) {
		super();
		this.phoneNumber = phoneNumber;
		this.savingPoint = savingPoint;
		this.usedPoint = usedPoint;
		this.remainPoint = remainPoint;
		this.totalPrice = totalPrice;
		this.finalPrice = finalPrice;
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

	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", savingPoint=" + savingPoint + ", usedPoint=" + usedPoint
				+ ", remainPoint=" + remainPoint + ", totalPrice=" + totalPrice + ", finalPrice=" + finalPrice + "]";
	}
	
	
}
