package day15.practice;

import java.util.Scanner;


public class ShopEx {
	
	static Scanner sc = new Scanner (System.in);
	
	public void run() {
		
		int menu;
		
		int tvCount = 1, airconCount = 2, radioCount = 3;
		HomeAppliance homeappliances[] = new HomeAppliance[10];
		int count = 0;

		for(int i = 0 ; i < tvCount ; i++) {
			homeappliances[count++] = new TV();
		}
		
		for(int i = 0 ; i < airconCount ; i++) {
			homeappliances[count++] = new AirConditioner();
		}
		
		for(int i = 0 ; i < radioCount ; i++) {
			homeappliances[count++] = new Radio();
		}
		
		
		
		// 메뉴 출력
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			doingMenu(menu);
			
		}while(menu!=5);
	
	}

	// 메뉴출력 메서드
	private void printMenu() {
		System.out.println("====== Menu =======");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("===================");
		System.out.print("메뉴를 선택하세요 : ");
	}
	
	
	// 메뉴 실행 메서드
	public void doingMenu(int menu) {
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			productInquiry();
			break;
		case 5:
			break;
		default:
				
		}
	}
	
	
	// 제품 조회
	public void productInquiry() {
		String product;
		System.out.print("제품 정보를 조회할 제품명을 입력하세요 : ");
		product = sc.next();
	}
	

	
}

class HomeAppliance{
	int price;
	int total;
	int totalCount;
	void salesPrice() {
		total += price;
	}
	void salesCount() {
		totalCount++;
	}
}

class Sales{
	public void salesPrice(HomeAppliance appliance) {
		appliance.salesPrice();
		System.out.println("The total sales amount is " + appliance.total );
	}
	public void salesCount(HomeAppliance appliance) {
		appliance.salesCount();
		System.out.println("The total sales volume is " +  appliance.totalCount);
	}
}


class TV extends  HomeAppliance{
	int price = 1000;
	String info = "";
}


class AirConditioner extends  HomeAppliance{
	int price = 2000;
	String info = "";
}


class Radio extends  HomeAppliance{
	int price = 3000;
	String info = "";
}