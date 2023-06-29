package com.kkh.manage;

import java.util.Date;

public class Order {
	private int s_no;
	private String s_tel;
	private String s_menu;
	private String s_count;
	private int s_price;
	private int s_confirm;
	private String s_type;
	private Date s_date;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int s_no, String s_tel, String s_menu, String s_count, int s_price, int s_confirm, String s_type,
			Date s_date) {
		super();
		this.s_no = s_no;
		this.s_tel = s_tel;
		this.s_menu = s_menu;
		this.s_count = s_count;
		this.s_price = s_price;
		this.s_confirm = s_confirm;
		this.s_type = s_type;
		this.s_date = s_date;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_tel() {
		return s_tel;
	}

	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}

	public String getS_menu() {
		return s_menu;
	}

	public void setS_menu(String s_menu) {
		this.s_menu = s_menu;
	}

	public String getS_count() {
		return s_count;
	}

	public void setS_count(String s_count) {
		this.s_count = s_count;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public int getS_confirm() {
		return s_confirm;
	}

	public void setS_confirm(int s_confirm) {
		this.s_confirm = s_confirm;
	}

	public String getS_type() {
		return s_type;
	}

	public void setS_type(String s_type) {
		this.s_type = s_type;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	
	
	
	
	
}
