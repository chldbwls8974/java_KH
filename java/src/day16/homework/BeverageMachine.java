package day16.homework;

import java.util.Scanner;

public class BeverageMachine {

	private Scanner sc = new Scanner(System.in);
	private Person person[] = new Person[10];
	private Soda soda = new Soda();
	private int money;
	
	public void run() {
		int menu = -1;
		
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu!=4);
	}
	
	// 메뉴 실행
	public void printMenu() {
		System.out.println("========= Menu =========");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.println("========================");
		System.out.print("메뉴를 입력하세요 : ");
	}
	
	// 메뉴 선
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			inputMoney();
			break;
		case 2: 
			selectMenu();
			break;
		case 3:
			store();
			break;
		case 4:
			break;
		default:
		}
	}
	
	// 1. 금액 투입
	public void inputMoney() {
		System.out.println("========================");
		System.out.print("금액을 투입하세요 : ");
		money = sc.nextInt();
		System.out.println(money);
	}
		
		
	private void selectMenu() {
		System.out.println("========================");
		System.out.println("1. 사이다   2. 콜라   3. 환타"); 
		System.out.print("뽑을 음료를 선택하세요 : ");
		int num = sc.nextInt();
		// 돈을 가져옴 getMoney
		
		switch(num) {
		case 1:
			System.out.println("사이다");
			money -= soda.getPrice();
			System.out.println(money);
			break;
		case 2:
			System.out.println("콜라");
			// 잔돈계산
			break;
		case 3:
			System.out.println("환타");
			//잔돈계산
			break;
		default:
		}
	}
	
	private void store() {
		// TODO Auto-generated method stub
		
	}

	

	
}
