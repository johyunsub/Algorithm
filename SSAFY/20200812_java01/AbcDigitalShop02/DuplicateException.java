package AbcDigitalShop02;

public class DuplicateException extends Exception{
	public DuplicateException() {
		System.out.println("오류: 상품 번호가 중복되었습니다.");
	}
}
