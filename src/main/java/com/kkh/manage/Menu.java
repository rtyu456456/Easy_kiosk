package com.kkh.manage;

public class Menu {
	private int m_no;
	private String m_name;
	private int m_price;
	private String m_img;
	private int m_ice;
	private String m_type;
	private String m_type_easy;
	private int m_weather;
	private int m_stock;

	public Menu() {
	}

	public Menu(int m_no, String m_name, int m_price, String m_img, int m_ice, String m_type, String m_type_easy,
			int m_weather, int m_stock) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_price = m_price;
		this.m_img = m_img;
		this.m_ice = m_ice;
		this.m_type = m_type;
		this.m_type_easy = m_type_easy;
		this.m_weather = m_weather;
		this.m_stock = m_stock;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_price() {
		return m_price;
	}

	public void setM_price(int m_price) {
		this.m_price = m_price;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public int getM_ice() {
		return m_ice;
	}

	public void setM_ice(int m_ice) {
		this.m_ice = m_ice;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public String getM_type_easy() {
		return m_type_easy;
	}

	public void setM_type_easy(String m_type_easy) {
		this.m_type_easy = m_type_easy;
	}

	public int getM_weather() {
		return m_weather;
	}

	public void setM_weather(int m_weather) {
		this.m_weather = m_weather;
	}

	public int getM_stock() {
		return m_stock;
	}

	public void setM_stock(int m_stock) {
		this.m_stock = m_stock;
	}

	@Override
	public String toString() {
		return "Menu [m_no=" + m_no + ", m_name=" + m_name + ", m_price=" + m_price + ", m_img=" + m_img + ", m_ice="
				+ m_ice + ", m_type=" + m_type + ", m_type_easy=" + m_type_easy + ", m_weather=" + m_weather
				+ ", m_stock=" + m_stock + "]";
	}
	
	

}


