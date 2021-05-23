package AbcDigitalShop02;

public interface ProductMgr {
//	상품정보(TV와 Refrigerator)를 저장
	public void add(Product prd);
//	상품정보 전체를 검색하는 기능
	public Product[] selectAll();
//	상품번호로 상품을 검색하는 기능
	public Product selectByPid(int pid);
//	상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	public Product[] selectByName(String name);
//	TV정보만 검색
	public Product[] selectOnlyTV();
//	Refrigerator만 검색
	public Product[] selectOnlyRef();
//	400L 이상의 Refrigerator 검색
	public void selectOver400L();
//	50inch 이상의 TV검색
	public void selelctOver50inch();
//	상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	public void updatePrice(int pid, int price);
//	상품번호로 상품을 삭제하는 기능
	public void delete(int pid);
// 	전체 재고 상품 금액을 구하는 기능
	public int selectSumPrice();
}
