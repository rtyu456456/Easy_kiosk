package com.easy_kiosk.sua;

public class SelectedMenu {

	private String price;
	private String ice;
	private String count;
	private String name;
	private String size;
	private String img;
	
	public SelectedMenu() {
		// TODO Auto-generated constructor stub
	}

	public SelectedMenu(String price, String ice, String count, String name, String size, String img) {
		super();
		this.price = price;
		this.ice = ice;
		this.count = count;
		this.name = name;
		this.size = size;
		this.img = img;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "SelectedMenu [price=" + price + ", ice=" + ice + ", count=" + count + ", name=" + name + ", size="
				+ size + ", img=" + img + "]";
	}
	
}
