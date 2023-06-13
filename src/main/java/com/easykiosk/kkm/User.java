package com.easykiosk.kkm;

public class User {
	private String phoneNumber;
	private int point;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String phoneNumber, int point) {
		super();
		this.phoneNumber = phoneNumber;
		this.point = point;
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

	@Override
	public String toString() {
		return "USER [phoneNumber=" + phoneNumber + ", point=" + point + "]";
	}
	
	
	
}
