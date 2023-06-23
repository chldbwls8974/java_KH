package day16.homework2.controller;

import java.util.Scanner;

import day16.homework2.vo.Beverage2;

public class BeverageMachine2 {
	
	private Scanner sc = new Scanner(System.in);
	private Beverage2 list[] = new Beverage2[3];
	
	
	private final static int SODA = 0;
	private final static int COKE = 1;
	private final static int FANTA = 2;
	private final static int EXIT = 3;
	private int money;
	
	
	public BeverageMachine2() {
		list[SODA] = new Beverage2("soda", 1200, 10);
		list[COKE] = new Beverage2("coke", 2000, 10);
		list[FANTA] = new Beverage2("fanta", 1500, 10);
		
	}

	public void run() {
		
		int menu = -1;
		
		do {
			
			printmenu();
			menu = sc.nextInt();
			selecetMenu(menu);
			
			
		}while(menu!=EXIT);
		
	}

	private void selecetMenu(int menu) {
		switch(menu) {
		case 1:
			inputMoney();
			break;
		case 2: 
			selectSubMenu();
			break;
		case 3:
			store();
			break;
		case 4:
			break;
		default:
		}		
	}

	private void selectSubMenu() {
		// TODO Auto-generated method stub
		
	}

	private void store() {
		// TODO Auto-generated method stub
		
	}

	private void inputMoney() {
		// TODO Auto-generated method stub
		
	}

	private void printmenu() {
		System.out.println("========= Menu =========");
		System.out.println("1. 금액 투입"); // 잔돈이 나오면 금액이 0이 되게 수정할것, 잔돈이 나오지 않고 돈만 추가로 투입하는 경우에는 누적
		System.out.println("2. 메뉴 선택"); // 메뉴 선택시 재고가 모자라면 재고 모자라다는 오류창 출력 // 금액이 모자라면 금액이 모자라다는 오류창 출력
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.println("========================");
		System.out.print("메뉴를 입력하세요 : ");
	}

}
