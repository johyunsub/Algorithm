package com.ssafy.hw.step05;

public class ProductMgr {
	
	//SingleTon pattern
	static ProductMgr pMgr = null;
	
	public static ProductMgr getInstance() {
		if(pMgr == null)
			pMgr = new ProductMgr();
		return pMgr;
	}
	
	Product[] Product = new Product[100];
	static int index = 0;
	
	//파라미터로 전달된 상품을 저장하는 기능
	public void add(Product p) {
		Product[index] = p;
		index++;
	}
	
	//저장된 상품들을 볼수 있는 기능
	public Product[] list() {
		//Product[] Plist = new Product[100];
		return Product;
	}
	
	//상품 번호로 검색하는 기능
	public Product list(int num) {
		int i;
		for(i=0; i<index; i++) {
			if(Product[i].getNum() == num) {
				break;
			}
		}
		return Product[i];
	}
	
	//상품 번호로 삭제하는 기능
	public void delete(int num) {
		for(int i=0; i<index; i++) {
			if(Product[i].getNum() == num) {
				for(int j=i; j<index; j++) {
					Product[j] = Product[j+1];
				}
				break;
			}
		}
	}
	
	//특정가격 이하의 상품만 검색하는 기능
	public Product[] priceList(int price) {
		Product[] pList = new Product[50];
		int j=0;
		for(int i=0; i<index; i++) {
			if(Product[i]==null) break;
			if(Product[i].getPrice() <= price) {
				pList[j] = Product[i];
				j++;
			}
		}
		return pList;
	}
	
	//저장된 상품 정보의 갯수를 리턴한다.
	public int getSize() {
		return Product.length;
	}
	
}
