package day15.pratice.shop.controller;
import java.util.Scanner;

import day15.practice.shop.vo.Customer;
import day15.practice.shop.vo.Product;
import day15.practice.shop.vo.Sales;

public class ShopManager {
	
	private Scanner sc = new Scanner (System.in);
	private Product list[] = new Product[10];
	private Customer customerList[] = new Customer[10];
	private Sales salesHistory[] = new Sales[100];
	private int salesCount = 0;
	private int productCount = 0;
	private int customerCount = 0;
	private int totalPrice; // 매출금액

	public void run() {
		
		int menu;
		
		System.out.println("Start!!");
		
		System.out.println("Running ... ");
		
		// 메뉴 출력
				do {
					printMenu();
					
					menu = sc.nextInt();
					
					doingMenu(menu);
					
				}while(menu!=6);
				
		System.out.println();
		System.out.println("Finish!!");
	}
	
	

	// 메뉴출력 메서드
	private void printMenu() {
		System.out.println("========= Menu =========");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 고객 추가");
		System.out.println("6. 프로그램 종료");
		System.out.println("========================");
		System.out.print("메뉴를 선택하세요 : ");
	}

	// 메뉴 실행 메서드
	public void doingMenu(int menu) {
		switch(menu) {
		case 1:
			sell();
			break;
		case 2:
			store();
			break;
		case 3:
			printProduct();
			break;
		case 4:
			printSales();
			break;
		case 5:
			registerCustomer();
			break;
		case 6:
			break;
		default:
				
		}
	}
		
		
	private void sell() {
		// 어떤 고객이 어떤 제품을 구매했는지 관리
		// 제품명과 제품 갯수를 입력받고
		// 고객정보도 입력 받는다
		// 판매 내역에 추가하고 매출금액을 추가한다.
		
		System.out.print("제품명을 입력하세요. : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("제품 수량을 입력하세요. : ");
		int amount = sc.nextInt();
		System.out.print("고객 핸드폰번호를 입력하세요 : ");
		String phoneNumber = sc.next();
		
		if(indexOf(name)== -1 ) {
			System.out.println("========================");
			System.out.println("등록되지 않은 제품입니다.");
			return;
		}
		
		if(productShipment(name,amount)==1) return;
		
		if(indexOfCustome(phoneNumber) == -1) {
			System.out.println("========================");
			System.out.println("등록되지 않은 고객입니다.");
			System.out.print("신규 고객으로 새로 등록하시려면 1번을, 아니면 2번을 입력하세요. : ");
			int num = sc.nextInt();
			if(num==1) {registerCustomer();}
			return;
		}
		
		// 판매내역에 추가
		// 제품 정보
		// 복사 생성자를 이용해서 제품 정보를 복사 (깊은 복사)
		Product product = new Product(list[indexOf(name)]);
		product.setAmount(amount);
		
		// 고객 정보
		Customer customer = customerList[indexOfCustome(phoneNumber)];
		Sales sales = new Sales(customer, product);
		salesHistory[salesCount++] = sales;
		
		// 판매된 개수만큼 재고량에서 빼줘야함.
		list[indexOf(name)].release(amount);
		
		// 매출금액 추가
		totalPrice += sales.getTotalPrice();
		System.out.println(totalPrice);
	}



	// 고객 등록
	private void registerCustomer() {
		System.out.println("========================");
		System.out.print("신규 고객의 성함을 입력하세요 : ");
		String name = sc.next();
		System.out.print("신규 고객의 핸드폰 번호를 입력하세요 : ");
		sc.nextLine();
		String phoneNumber = sc.nextLine();
		
		if(indexOfCustomer(phoneNumber) != -1) {
			System.out.println("========================");
			System.out.println("이미 등록된 고객입니다.");
			return;
		}
					
		customerList[customerCount++] = new Customer(name,phoneNumber);
		System.out.println("========================");
		System.out.println("등록되었습니다.");
	}



	private void printSales() {
		for(int i = 0 ; i < salesCount ; i++) {
			salesHistory[i].print();
		}
		
		// 누적 매출액 출력
		System.out.println("누적 매출액 : " + totalPrice);
	}



	// 제품을 검색해서 조회하는 메서드
	private void printProduct() {
		System.out.println("========================");
		System.out.print("검색하실 제품명을 입력하세요 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		if(indexOf(name)!= -1) {
			System.out.println("========================");
			System.out.println("입력하신 제품은 " + (indexOf(name) + 1 ) + "번째에 있습니다.");
			System.out.println("입력하신 제품의 정보는 다음과 같습니다.");
			list[indexOf(name)].print(name);
			return;
		}
		System.out.println("========================");
		System.out.println("입력하신 제품은 없습니다.");
		
	}

	
	// 제품 위치 찾기
	public int indexOf(String name) {
		for(int i = 0 ; i < productCount ; i++) {
			if(list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	
	// 핸드폰으로 고객 위치 찾기
	public int indexOfCustome(String phoneNumber) {
		for(int i = 0 ; i < customerCount ; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}
	
	// 이름으로 고객 찾기
	public int indexOfCustomer(String name) {
		for(int i = 0 ; i < customerCount ; i++) {
			if(customerList[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	
	// 제품 입고
	private void store() {
		//입고할 제품명 입력
		System.out.println("========================");
		System.out.print("입고할 제품명을 입력하세요.");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입고할 제품 수량
		System.out.print("입고할 제품의 수량을 입력하세요.");
		int amount = sc.nextInt();
		
		if(amount < 0) {
			System.out.println("========================");
			System.out.println("입고 수량 오류");
			return;
		}
		
		if(indexOf(name)!= -1) {
			list[indexOf(name)].store(amount);
			System.out.println("========================");
			System.out.println("입고 완료");
			return;
		}
		
		if(productCount == list.length) {
			System.out.println("========================");
			System.out.println("제품 리스트 다 참");
			return;
		}
		// 모델명 입력
		System.out.println("========================");
		System.out.println("새 제품 등록");
		System.out.print("모델명 : ");
		sc.nextLine();
		String modelName = sc.nextLine();
		
		// 가격을 입력
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		// 카테고리를 입력
		System.out.print("분류 : ");
		String category = sc.next();
		
		// 제품 리스트에 추가
		list[productCount++] = new Product(name, modelName, price, amount, category);
		
		System.out.println("========================");
		System.out.println("제품 추가 후 입고 완료");
	}
	

	// 제품 출고
	public int productShipment(String name, int amount) {
		// 수량 오류
		if(amount < 0) {
			System.out.println("========================");
			System.out.println("수량 오류");
			return 1;
		}
		
		if(indexOf(name)!= -1) {
			//재고 없음
			if(list[indexOf(name)].getAmount() <= 0 ) {
				System.out.println("========================");
				System.out.println("재고 없음");
				return 1;
			}
			
			// 재고 모자람
			if(list[indexOf(name)].getAmount() < amount) {
				System.out.println("========================");
				System.out.println("재고 모자람");
				return 1;
			}
			
			
			//list[indexOf(name)].release(amount);
			//return 3;	
		}
		return 0;
				
	}
		


}
