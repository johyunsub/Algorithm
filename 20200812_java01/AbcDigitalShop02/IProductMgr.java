package AbcDigitalShop02;

import java.util.ArrayList;

import AbcDigitalShopSolution.DuplicateException;

public interface IProductMgr {
	public void add(Product prd) throws DuplicateException;	//상품정보 입력 기능
	public void selectAll() throws ProductNotFoundException;	//상품정보 전체를 검색하는 기능
	public Product selectByPid(int pid) throws CodeNotFoundException;	//상품번호로 상품을 검색하는 기능
	public ArrayList<Product> selectByName(String name);	//상품명로 상품을 검색하는 기능
	public ArrayList<Product> selectOnlyTV();	//TV정보로만 검색
	public ArrayList<Product> selectOnlyRef();	//Refrigerator정보로만 검색
	public ArrayList<Product> selectOver400L() throws ProductNotFoundException;	//400L 이상의 Refrigerator 검색
	public ArrayList<Product> selelctOver50inch() throws ProductNotFoundException;	//50inch 이상의 TV검색
	public void updatePrice(int pid, int price);	//상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	public void delete(int pid);	//상품번호로 상품 삭제 기능 
	public int selectSumPrice();	//전체 재고 상품 금액 
	
}
