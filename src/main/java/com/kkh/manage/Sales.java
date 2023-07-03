package com.kkh.manage;

import java.util.Date;

public class Sales {
	private Date s_date;
	private int s_price;
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(Date s_date, int s_price) {
		super();
		this.s_date = s_date;
		this.s_price = s_price;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	@Override
	public String toString() {
		return "Sales [s_date=" + s_date + ", s_price=" + s_price + "]";
	}
	
	
	
}
