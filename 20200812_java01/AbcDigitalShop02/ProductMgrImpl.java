package AbcDigitalShop02;

import java.util.ArrayList;
import java.util.Iterator;

import AbcDigitalShopSolution.DuplicateException;

public class ProductMgrImpl implements IProductMgr {
	ArrayList<Product> Products = new ArrayList<Product>();
	ArrayList<Product> RefList, TvList;
	
	static int index;
	
	//SingleTon pattern
	private static ProductMgrImpl productMgr = null;
	public static ProductMgrImpl getInstance() {
		if (productMgr == null) {
			productMgr = new ProductMgrImpl();
		}
		return productMgr;
	}
	
	//상품정보 입력 기능
	@Override
	public void add(Product prd) throws DuplicateException {
		Iterator<Product> ite = Products.iterator();
		while(ite.hasNext()) {	
			if(ite.next().getPid()==prd.getPid()) {
				throw new DuplicateException();	//상품이 중복되었을 떄 throw
			}
		}
		Products.add(prd);
		System.out.println("상품 정보가 등록되었습니다.");
	}
	
	//상품정보 전체를 검색하는 기능
	@Override
	public void selectAll() throws ProductNotFoundException {
		Iterator<Product> ite = Products.iterator();	//순환자생성
		if(Products.isEmpty()) { 	//상품이 존재하지 않을때 throw
			throw new ProductNotFoundException();
		}
		while(ite.hasNext()) {
			System.out.println(ite.next());	//순환자가 가리키는 객체 출력
		}
	}
	
	//상품번호로 상품을 검색하는 기능
	@Override
	public Product selectByPid(int pid) throws CodeNotFoundException{
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(pid == p.getPid()) {
				return p;
			}
		}
		return null;
	}
	
	//상품명으로 상품을 검색하는 기능
	@Override
	public ArrayList<Product> selectByName(String name) {
		ArrayList<Product> temp = new ArrayList<Product>();
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p.getName().contains(name))
				temp.add(p);
		}
		return temp;
	}
	
	//TV정보로만 검색
	@Override
	public ArrayList<Product> selectOnlyTV() {
		ArrayList<Product> temp = new ArrayList<Product>();
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p instanceof TV)
				temp.add(p);
		}
		return temp;
	}
	//Refrigerator정보로만 검색
	@Override
	public ArrayList<Product> selectOnlyRef() {
		ArrayList<Product> temp = new ArrayList<Product>();
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p instanceof Refrigerator)
				temp.add(p);
		}
		return temp;
	}
//	400L 이상의 Refrigerator 검색
	@Override
	public ArrayList<Product> selectOver400L() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p instanceof Refrigerator)
				if(((Refrigerator)p).getLitter() >= 400) {
					temp.add(p);	//리스트에 추가
				}
		}
		return temp;
	}
//	50inch 이상의 TV검색
	@Override
	public ArrayList<Product> selelctOver50inch() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p instanceof TV)
				if(((TV)p).getInch() >= 50) {
					temp.add(p);	//리스트에 추가
				}
		}
		return temp;
	}
//	상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	@Override
	public void updatePrice(int pid, int price) {
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p.getPid() == pid) {
				p.setPrice(price);
				break;
			}
		}
		System.out.println("상품가격 수정 완료!");
	}
	
	//상품번호로 상품 삭제 기능 
	@Override
	public void delete(int pid) {
		Iterator<Product> ite = Products.iterator();
		Product p;
		while(ite.hasNext()) {
			p = ite.next();
			if(p.getPid() == pid) {
				Products.remove(p);
				break;
			}
		}
		System.out.println("상품삭제 완료!");
	}
	
	//전체 재고 상품 금액 
	@Override
	public int selectSumPrice() {
		Iterator<Product> ite = Products.iterator();
		int sum = 0;
		while(ite.hasNext()) {
			sum += ite.next().getPrice();
		}return sum;
	}
}
