package AbcDigitalShop;

import java.util.Scanner;
public class ProductTest {
	
	ProductMgr pMgr = ProductMgr.getInstance();
	Scanner sc = new Scanner(System.in);
	
	int showMenu() {
		System.out.println();
		System.out.println("========================");
		System.out.println("1. 입력");
		System.out.println("2. 상품 전체 검색");
		System.out.println("3. 상품번호 검색");
		System.out.println("4. 상품명 검색(부분검색 가능)");
		System.out.println("5. TV만 검색");
		System.out.println("6. 냉장고만 검색");
		System.out.println("7. 상품 번호로 상품 삭제");
		System.out.println("8. 전체 재고 합계 금액 보기");
		System.out.println("0. 종료");
		System.out.println("========================");
		System.out.print("원하는 번호를 선택 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void service() {
		System.out.println("<<< 상품 관리 프로그램 >>>");

		while (true) {
			switch (showMenu()) {
			case 0:
				System.out.println("종료합니다.");
				System.exit(0);
			case 1:
				addPrd();
				break;
			case 2:
				searchAllBook();
				break;
			case 3:
				searchPid();
				break;
			case 4:
				searchName();
				break;
			case 5:
				searchOnlyTV();
				break;
			case 6:
				searchOnlyRef();
				break;
			case 7:
				deleteByPid();
				break;
			case 8:
				showSum();
				break;
			default:
				System.out.println("잘못된 메뉴를 선택하였습니다.");
				break;
			}
		}
	}
	
	
	private void showSum() {
		System.out.println("8. 전체 도서 합계 금액 보기");
		System.out.println();
		System.out.println("전체 금액 : " + pMgr.selectSumPrice());
	}

	private void deleteByPid() {
		System.out.println("7. 상품번호로 삭제");
		System.out.println();
		pMgr.delete(Integer.parseInt(sc.nextLine()));
	}

	private void searchOnlyRef() {
		System.out.println("6. 냉장고만 검색");
		System.out.println();
		print(pMgr.selectOnlyRef());
	}

	private void searchOnlyTV() {
		System.out.println("5. TV만 검색");
		System.out.println();
		print(pMgr.selectOnlyTV());
	}

	private void searchName() {
		System.out.println("4. 상품명 검색");
		System.out.println();
		System.out.print("상품명 : ");
		print(pMgr.selectByName(sc.nextLine()));
	}

	private void searchPid() {
		System.out.println("3. 상품번호 검색");
		System.out.print("검색할 상품번호 :");
		Product product = pMgr.selectByPid(sc.nextInt());
		if (product == null) {
			System.out.println("검색한 번호에 해당하는  상품이 없습니다.");
			return;
		}
		System.out.println(product);
	}
	
	private void print(Product[] products) {
		System.out.println("------------------------");
		for(int i=0; i<products.length; i++) {
			System.out.println(products[i]);
		}
		if(products.length == 0) System.out.println("검색된 상품이 없습니다.");
		System.out.println("------------------------");
	}
	private void searchAllBook() {
		System.out.println("2. 전체 검색");
		System.out.println();
		print(pMgr.selectAll());
	}

	private void addPrd() {
		System.out.println("1. 상품정보 입력");
		System.out.println("입력(1. TV, 2. 냉장고) : ");
		int kind = Integer.parseInt(sc.nextLine());
		
		System.out.println("상품번호 : ");
		int pid = Integer.parseInt(sc.nextLine());
		System.out.println("상품명: ");
		String name = sc.nextLine();
		System.out.println("상품 가격: ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("수량: ");
		int amount = Integer.parseInt(sc.nextLine());
		
		if(kind == 1) {
			pMgr.add(new TV(pid, name, price, amount));
		}
		else if(kind == 2) {
			pMgr.add(new Refrigerator(pid, name, price, amount));
		}
		System.out.println("상품 정보가 등록되었습니다.");
	}
	

	public static void main(String[] args) {
		new ProductTest().service();
	}

}
