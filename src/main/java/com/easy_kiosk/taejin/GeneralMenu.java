package com.easy_kiosk.generalmenu;

public class GeneralMenu {
	private String no;
	private String name;
	private int price; 
	private String img;  
	private int ice; 
	private int size;  
	private String type; 
	private String typeEasy;
	private String option;
	private String desc;
	private int weather;
	private int soldout;
	private int order;
	
	public GeneralMenu() {
		// TODO Auto-generated constructor stub
	}

	public GeneralMenu(String no, String name, int price, String img, int ice, int size, String type, String typeEasy,
			String option, String desc, int weather, int soldout, int order) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.img = img;
		this.ice = ice;
		this.size = size;
		this.type = type;
		this.typeEasy = typeEasy;
		this.option = option;
		this.desc = desc;
		this.weather = weather;
		this.soldout = soldout;
		this.order = order;
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

	public int getIce() {
		return ice;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getWeather() {
		return weather;
	}

	public void setWeather(int weather) {
		this.weather = weather;
	}

	public int getSoldout() {
		return soldout;
	}

	public void setSoldout(int soldout) {
		this.soldout = soldout;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
}
