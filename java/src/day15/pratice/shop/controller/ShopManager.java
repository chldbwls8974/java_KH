package day15.pratice.shop.controller;
import java.util.Scanner;

import day15.practice.shop.vo.Product;

public class ShopManager {
	
	private Scanner sc = new Scanner (System.in);
	private Product list[] = new Product[10];
	private int count = 0;

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
				
		
		System.out.println("Finish!!");
	}
	
	

	// 메뉴출력 메서드
	private void printMenu() {
		System.out.println("====== Menu =======");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 고객 추가");
		System.out.println("6. 프로그램 종료");
		System.out.println("===================");
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
		// TODO Auto-generated method stub
		
	}



	private void registerCustomer() {
		// TODO Auto-generated method stub
		
	}



	private void printSales() {
		// TODO Auto-generated method stub
		
	}



	private void printProduct() {
		// TODO Auto-generated method stub
		
	}



	// Product Shipment
	private void productShipment() {
		
		System.out.println("출고할 제품명을 입력하세요 :");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("출고할 제품의 수량을 입력하세요.");
		int amount = sc.nextInt();
	
		
		if(amount < 0) {
			System.out.println("출고 수량 오류");
			return;
		}
		
		if(indexOf(name)!= -1) {
			if(list[indexOf(name)].getAmount() <= 0 ) {
				System.out.println("재고 없음");
				return;
			}
			
			if(list[indexOf(name)].getAmount() < amount) {
				System.out.println("재고가 모자람.");
				return;
			}
			list[indexOf(name)].release(amount);
			System.out.println("출고 완료");
			return;	
		}
		
	}
	


	// 제품 위치 찾기
	public int indexOf(String name) {
		for(int i = 0 ; i < count ; i++) {
			if(list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	
	
	
	// 제품 입고
	private void store() {
		//입고할 제품명 입력
		System.out.println("입고할 제품명을 입력하세요.");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입고할 제품 수량
		System.out.println("입고할 제품의 수량을 입력하세요.");
		int amount = sc.nextInt();
		
		if(amount < 0) {
			System.out.println("입고 수량 오류");
			return;
		}
		
		if(indexOf(name)!= -1) {
			list[indexOf(name)].store(amount);
			System.out.println("입고 완료");
			return;
		}
		
		if(count == list.length) {
			System.out.println("제품 리스트 다 참");
			return;
		}
		// 모델명 입력
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
		list[count++] = new Product(name, modelName, price, price, category);
		
		System.out.println("제품 추가 후 입고 완료");
		

			// 있으면 입고할 제품 수량만큼 해당 제품에 입고
			// >> 위치가 0 이상이면
			// 없으면 제품 리스트에 제품 정보를 추가(입고할 수량도 함께)
			// >> 위치가 -1 이면
	}
	


}
