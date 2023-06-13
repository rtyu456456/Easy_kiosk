package com.sa.easy;

public class Menu {
	private String m_no;
	private String m_name;
	private int m_price;
	private String m_img;
	private String m_ice;
	private String m_type;
	private String m_type_easy;
	private String m_weather;
	private String m_stock;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String m_no, String m_name, int m_price, String m_img, String m_ice, String m_type, String m_type_easy,
			String m_weather, String m_stock) {
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

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
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

	public String getM_ice() {
		return m_ice;
	}

	public void setM_ice(String m_ice) {
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

	public String getM_weather() {
		return m_weather;
	}

	public void setM_weather(String m_weather) {
		this.m_weather = m_weather;
	}

	public String getM_stock() {
		return m_stock;
	}

	public void setM_stock(String m_stock) {
		this.m_stock = m_stock;
	}

	@Override
	public String toString() {
		return "Menu [m_no=" + m_no + ", m_name=" + m_name + ", m_price=" + m_price + ", m_img=" + m_img + ", m_ice="
				+ m_ice + ", m_type=" + m_type + ", m_type_easy=" + m_type_easy + ", m_weather=" + m_weather
				+ ", m_stock=" + m_stock + "]";
	}
	
	
	
}
