package com.ssafy.hw.step05;

import java.util.Scanner;

public class ProductTest {
	static Scanner sc = new Scanner(System.in);
	static ProductMgr productMgr = ProductMgr.getInstance();
	
	public static void main(String[] args) {
		
		int n=1;
		while(n != 0) {
			System.out.print("<<<재고 관리 프로그램>>>\n1. 상품 정보 입력\n2. 상품 정보 검색\n3. 상품 번호로 검색"
					+ "\n4. 상품 번호로 삭제\n5. 상품 가격으로 검색\n0. 종료\n원하는 번호를 선택하세요. ");
			n = sc.nextInt();
			sc.nextLine();
			
			switch(n) {
			case 0:
				System.out.println("종료합니다.");
				break;
			case 1:
				addProduct();
				break;
			case 2:
				printProduct();
				break;
			case 3:
				printNum();
				break;
			case 4:
				deleteNum();
				break;
			case 5:
				
				printPrice();
				break;
			default:
				System.out.println("Unavailable Choice");
				break;
			}
		}
	}

	public static void addProduct() {
		System.out.println("1. 상품 정보 입력");
		System.out.print("상품번호: ");
		int num = sc.nextInt();
		sc.nextLine();	//버퍼비우기
		System.out.print("상품명: ");
		String name = sc.nextLine();
		System.out.print("가격: ");
		int price = sc.nextInt();
		System.out.print("수량: ");
		int cnt = sc.nextInt();
		
		Product product = new Product(num, name, price, cnt);
		productMgr.add(product);
	}
	
	public static void printProduct() {
		for(int i=0; i<productMgr.getSize(); i++) {
			if(productMgr.Product[i]==null) break;
			System.out.print(productMgr.Product[i].getNum()+"\t");
			System.out.print(productMgr.Product[i].getName()+"\t");
			System.out.print(productMgr.Product[i].getPrice()+"\t");
			System.out.print(productMgr.Product[i].getCnt()+"\n");
		}
	}
	
	public static void printNum() {
		System.out.println("3. 상품번호로 검색");
		System.out.print("상품번호:");
		int num = sc.nextInt();
		
		if(productMgr.list(num) != null) {
			System.out.print(productMgr.list(num).getName()+"\t");
			System.out.print(productMgr.list(num).getPrice()+"\t");
			System.out.print(productMgr.list(num).getCnt()+"\n");
		}
	}
	
	public static void deleteNum() {
		System.out.println("4. 삭제하고자 하는 상품번호:");
		int num = sc.nextInt();
		productMgr.delete(num);
	}
	
	public static void printPrice() {
		System.out.println("5. 입력하신 가격 이하로 검색");
		System.out.print("상품 가격:");
		int price = sc.nextInt();
		
		for(int i=0; i<productMgr.priceList(price).length; i++) {
			if(productMgr.priceList(price)[i] == null) break; 
			System.out.print(productMgr.priceList(price)[i].getNum()+"\t");
			System.out.print(productMgr.priceList(price)[i].getName()+"\t");
			System.out.print(productMgr.priceList(price)[i].getPrice()+"\t");
			System.out.print(productMgr.priceList(price)[i].getCnt()+"\n");
		}
	}

	
}
