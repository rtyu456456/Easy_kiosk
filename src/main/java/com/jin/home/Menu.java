package com.jin.home;

public class Menu {
	private String no;
	private String name;
	private int price; 
	private String img;  
	private String ice; 
	private String type; 
	private String typeEasy;
	private String weather;
	private String stock;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu(String no, String name, int price, String img, String ice, String type, String typeEasy, String weather,
			String stock) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.img = img;
		this.ice = ice;
		this.type = type;
		this.typeEasy = typeEasy;
		this.weather = weather;
		this.stock = stock;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
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
	public String getIce() {
		return ice;
	}
	public void setIce(String ice) {
		this.ice = ice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeEasy() {
		return typeEasy;
	}
	public void setTypeEasy(String typeEasy) {
		this.typeEasy = typeEasy;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}	
}
