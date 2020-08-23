package AbcDigitalShop02;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException() {
		System.out.println("오류: 해당 상품이 존재하지 않습니다.");
	}
}
