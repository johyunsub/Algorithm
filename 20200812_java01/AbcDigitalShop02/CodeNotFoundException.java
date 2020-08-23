package AbcDigitalShop02;

public class CodeNotFoundException extends Exception{
	public CodeNotFoundException() {
		System.out.println("해당 상품번호의 상품이 존재하지 않습니다.");
	}
}
