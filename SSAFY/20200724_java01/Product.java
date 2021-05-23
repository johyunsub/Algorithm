package com.ssafy.hw.step05;

public class Product {
	private int num;
	private String name;
	private int price;
	private int cnt;
	
	public Product() {}

	public Product(int num, String name, int price, int cnt) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
