package com.easy_kiosk.sua;

public class Menu {
	private String m_no;
	private String m_name;
	private int m_price;
	private String m_img;
	private int m_ice;
	private int m_size;
	private String m_type;
	private String m_type_easy;
	private String m_option;
	private String m_desc;
	private int m_weather;
	private int m_soldout;
	private int m_order;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String m_no, String m_name, int m_price, String m_img, int m_ice, int m_size, String m_type,
			String m_type_easy, String m_option, String m_desc, int m_weather, int m_soldout, int m_order) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_price = m_price;
		this.m_img = m_img;
		this.m_ice = m_ice;
		this.m_size = m_size;
		this.m_type = m_type;
		this.m_type_easy = m_type_easy;
		this.m_option = m_option;
		this.m_desc = m_desc;
		this.m_weather = m_weather;
		this.m_soldout = m_soldout;
		this.m_order = m_order;
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

	public int getM_ice() {
		return m_ice;
	}

	public void setM_ice(int m_ice) {
		this.m_ice = m_ice;
	}

	public int getM_size() {
		return m_size;
	}

	public void setM_size(int m_size) {
		this.m_size = m_size;
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

	public String getM_option() {
		return m_option;
	}

	public void setM_option(String m_option) {
		this.m_option = m_option;
	}

	public String getM_desc() {
		return m_desc;
	}

	public void setM_desc(String m_desc) {
		this.m_desc = m_desc;
	}

	public int getM_weather() {
		return m_weather;
	}

	public void setM_weather(int m_weather) {
		this.m_weather = m_weather;
	}

	public int getM_soldout() {
		return m_soldout;
	}

	public void setM_soldout(int m_soldout) {
		this.m_soldout = m_soldout;
	}

	public int getM_order() {
		return m_order;
	}

	public void setM_order(int m_order) {
		this.m_order = m_order;
	}

	@Override
	public String toString() {
		return "Menu [m_no=" + m_no + ", m_name=" + m_name + ", m_price=" + m_price + ", m_img=" + m_img + ", m_ice="
				+ m_ice + ", m_size=" + m_size + ", m_type=" + m_type + ", m_type_easy=" + m_type_easy + ", m_option="
				+ m_option + ", m_desc=" + m_desc + ", m_weather=" + m_weather + ", m_soldout=" + m_soldout
				+ ", m_order=" + m_order + "]";
	}
	
	
	
	
}
