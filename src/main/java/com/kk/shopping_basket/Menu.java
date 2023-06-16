package com.kk.shopping_basket;

public class Menu {
	private int no;
	private String name;
	private int price;
	private String img;
	private int ice;
	private String type;
	private String typeeasy;
	private int weather;
	private int stock;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int no, String name, int price, String img, int ice, String type, String typeeasy, int weather,
			int stock) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.img = img;
		this.ice = ice;
		this.type = type;
		this.typeeasy = typeeasy;
		this.weather = weather;
		this.stock = stock;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getIce() {
		return ice;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeeasy() {
		return typeeasy;
	}

	public void setTypeeasy(String typeeasy) {
		this.typeeasy = typeeasy;
	}

	public int getWeather() {
		return weather;
	}

	public void setWeather(int weather) {
		this.weather = weather;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
