package AbcDigitalShop;

public class ProductMgr {
	Product[] products = new Product[100];
	static int index;
	
	//SingleTon pattern
	private static ProductMgr productMgr = null;
	public static ProductMgr getInstance() {
		if (productMgr == null) {
			productMgr = new ProductMgr();
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
