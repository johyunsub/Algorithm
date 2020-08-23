package AbcDigitalShop02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductTest {
	
	ProductMgrImpl pMgr = ProductMgrImpl.getInstance();
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
		System.out.println("7. 400L 이상 냉장고 검색");
		System.out.println("8. 50인치 이상 TV 검색");
		System.out.println("9. 상품번호로 상품 가격 변경");
		System.out.println("10. 상품 번호로 상품 삭제");
		System.out.println("11. 전체 재고 합계 금액 보기");
		System.out.println("0. 종료");
		System.out.println("========================");
		System.out.print("원하는 번호를 선택 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void service() {
		System.out.println("<<< 상품 관리 프로그램 >>>");

		while (true) {
			try {
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
					searchLitter();
					break;
				case 8:
					searchInch();
					break;
				case 9:
					updatePrice();
					break;
				case 10:
					deleteByPid();
					break;
				case 11:
					showSum();
					break;
				default:
					System.out.println("잘못된 메뉴를 선택하였습니다.");
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void showSum() {
		System.out.println("11. 전체 재고 합계 금액 보기");
		System.out.println();
		System.out.println("전체 금액 : " + pMgr.selectSumPrice());
	}

	private void deleteByPid() {
		System.out.println("10. 상품번호로 삭제");
		System.out.println("삭제할 번호: ");
		pMgr.delete(Integer.parseInt(sc.nextLine()));
		System.out.println();
	}
	
	private void updatePrice() {
		System.out.println("9. 상품 가격 변경");
		System.out.println("변경할 상품번호: ");
		int pid = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 상품 가격: ");
		int price = Integer.parseInt(sc.nextLine());
		pMgr.updatePrice(pid, price);
		
	}
	private void searchInch() throws ProductNotFoundException {
		System.out.println("8. 50인치 이상 TV 검색");
		System.out.println();
		print(pMgr.selelctOver50inch());
	}
	private void searchLitter() throws ProductNotFoundException {
		System.out.println("7. 400L 이상 냉장고 검색");
		System.out.println();
		print(pMgr.selectOver400L());
	}
	
	private void searchOnlyRef() throws ProductNotFoundException {
		System.out.println("6. 냉장고만 검색");
		System.out.println();
		print(pMgr.selectOnlyRef());
	}

	private void searchOnlyTV() throws ProductNotFoundException {
		System.out.println("5. TV만 검색");
		System.out.println();
		print(pMgr.selectOnlyTV());
	}

	private void searchName() throws ProductNotFoundException {
		System.out.println("4. 상품명 검색");
		System.out.println();
		System.out.print("상품명 : ");
		print(pMgr.selectByName(sc.nextLine()));
	}

	private void searchPid() throws CodeNotFoundException{
		System.out.println("3. 상품번호 검색");
		System.out.print("검색할 상품번호 :");
		Product product = pMgr.selectByPid(Integer.parseInt(sc.nextLine()));
		if(product == null) {
			throw new CodeNotFoundException();
		}else
			System.out.println(product);
	}
	
	private void print(ArrayList<Product> list) throws ProductNotFoundException {
		System.out.println("------------------------");
		Iterator<Product> ite = list.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		if(list.isEmpty())
			throw new ProductNotFoundException();
		System.out.println("------------------------");
	}
	
	private void searchAllBook() throws ProductNotFoundException {
		System.out.println("2. 전체 검색");
		System.out.println();
		pMgr.selectAll();
	}

	private void addPrd() throws DuplicateException{
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
			System.out.println("크기: ");
			int inch = Integer.parseInt(sc.nextLine());
			pMgr.add(new TV(pid, name, price, amount, inch));
		}
		else if(kind == 2) {
			System.out.println("용량: ");
			int litter = Integer.parseInt(sc.nextLine());
			pMgr.add(new Refrigerator(pid, name, price, amount, litter));
		}
	}
	

	public static void main(String[] args) {
		new ProductTest().service();
	}

}


