package com.ssafy.hw04;

public class ProductTest {
	public static void main(String args[]) {
		TV tv = new TV("삼성TV");
		tv.setCode(0001);
		tv.setPrice(10000);
		tv.setAmount(10);
		tv.setInch(30);
		tv.setDisplay("아몰레드");
		
		System.out.println(tv);
		
		Refrigerator rf= new Refrigerator("삼성냉장고");
		rf.setCode(0002);
		rf.setPrice(20000);
		rf.setAmount(20);
		rf.setSize(100);
		
		
		System.out.println(rf);
	}
}

//TV클래스
class TV{
	private int code;
	private String name;
	private int price;
	private int amount;
	private int inch;
	private String display;
	
	public TV() {}
	
	public TV(String name) {
		this.name = name;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public String toString() {
		return this.name + ": 제품번호(" + this.code + ") 가격(" + price + "원) 수량(" + 
				this.amount + "대) 인치(" + this.inch + "인치) 타입(" + this.display + ")";
	}
}

//냉장고 클래스
class Refrigerator{
	private int code;
	private String name;
	private int price;
	private int amount;
	private int size;
	
	public Refrigerator() {}
	
	public Refrigerator(String name) {
		this.name = name;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String toString() {
		return this.name + ": 제품번호(" + this.code + ") 가격(" + price + "원) 수량(" + 
				this.amount+ "대) 용량(" + this.size + "리터)";
	}
}
