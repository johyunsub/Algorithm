package AbcDigitalShop02;

import java.util.ArrayList;

public class ProductMgrImpl {
	Product[] products = new Product[100];
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
	public void add(Product prd) {
		products[index++] = prd;
	}
	
	//상품정보 전체를 검색하는 기능
	public Product[] selectAll() {
		Product[] prd = new Product[index];
		for(int i=0; i<index; i++) {
			prd[i] = products[i];
		}
		return prd;
	}
	
	//상품번호로 상품을 검색하는 기능
	public Product selectByPid(int pid) {
		for(int i=0; i<index; i++) {
			if(products[i].getPid() == pid) {
				return products[i];
			}
		}
		return null;
	}
	
	//상품명로 상품을 검색하는 기능
	public Product[] selectByName(String name) {
		int size = 0;
		for (int i = 0; i < index; i++) {
			if (products[i].getName().contains(name) == false)
				continue;
			size++;
		}
		
		int inputSize = 0;
		Product[] temp = new Product[size];
		for (int i = 0; i < index; ++i) {
			if (products[i].getName().contains(name) == false)
				continue;
			
			temp[inputSize++] = products[i];
		}

		return temp;
	}
	
	//TV정보로만 검색
	public Product[] selectOnlyTV() {
		int size = 0;
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof TV)
				continue;
			size++;
		}
		
		int inputSize = 0;
		Product[] temp = new Product[size];
		for (int i = 0; i < index; ++i) {
			if (products[i] instanceof TV)
				temp[inputSize++] = products[i];
		}
		return temp;
	}
	//Refrigerator정보로만 검색
	public Product[] selectOnlyRef() {
		int size = 0;
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof Refrigerator)
				continue;
			size++;
		}
		
		int inputSize = 0;
		Product[] temp = new Product[size];
		for (int i = 0; i < index; ++i) {
			if (products[i] instanceof Refrigerator)
				temp[inputSize++] = products[i];
		}
		return temp;
	}
//	400L 이상의 Refrigerator 검색
	public void selectOver400L() {
		RefList = new ArrayList<Product>();
		for(int i=0; i<index; i++) {
			if(products[i] instanceof Refrigerator) {
				if(((Refrigerator)products[i]).getLitter() >= 400) {	//캐스팅후 검색
					RefList.add(products[i]);	//리스트에 추가
				}
			}
		}
		for(int i=0; i<RefList.size(); i++) {
			System.out.println(RefList.get(i));
		}
	}
//	50inch 이상의 TV검색
	public void selelctOver50inch() {
		TvList = new ArrayList<Product>();
		for(int i=0; i<index; i++) {
			if(products[i] instanceof TV) {
				if(((TV)products[i]).getInch() >= 50) {
					TvList.add(products[i]);
				}
			}
		}
		for(int i=0; i<TvList.size(); i++) {
			System.out.println(TvList.get(i));
		}
	}
//	상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	public void updatePrice(int pid, int price) {
		for(int i=0; i<index; i++) {
			if(products[i].getPid() == pid) {	
				products[i].setPrice(price);	//상품 가격 수정
				break;
			}else
				System.out.println("해당 상품이 존재하지 않습니다.");
		}
	}
	
	//상품번호로 상품 삭제 기능 
	public void delete(int pid) {
		for(int i=0; i<index; i++) {
			if(products[i] == null) continue;
			if(products[i].getPid() == pid) {
				for(int j=i; j<index; j++) {
					if(products[j] == null) continue;
					products[j] = products[j+1];
				}
				break;
			}
		}
		index--;
	}
	
	//전체 재고 상품 금액 
	public int selectSumPrice() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += products[i].getPrice();
		}
		return sum;
	}
}
