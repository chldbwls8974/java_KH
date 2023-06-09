package day16.homework;

import java.util.Scanner;

public class BeverageMachine {

	private Scanner sc = new Scanner(System.in);
	private Soda soda = new Soda();
	private Coke coke = new Coke();
	private Fanta fanta = new Fanta();
	private int money = 0;
	
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
		System.out.println("1. 금액 투입"); // 잔돈이 나오면 금액이 0이 되게 수정할것, 잔돈이 나오지 않고 돈만 추가로 투입하는 경우에는 누적
		System.out.println("2. 메뉴 선택"); // 메뉴 선택시 재고가 모자라면 재고 모자라다는 오류창 출력 // 금액이 모자라면 금액이 모자라다는 오류창 출력
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
		int coin = sc.nextInt();
		money += coin;
		System.out.println(money);
	}
		
		
	private void selectMenu() {
		System.out.println("========================");
		System.out.println("1. 사이다   2. 콜라   3. 환타"); 
		System.out.print("뽑을 음료를 선택하세요 : ");
		int menu = sc.nextInt();
		// 돈을 가져옴 getMoney
		
		switch(menu) {
		case 1:
			System.out.println("사이다가 나옵니다.");
			money -= soda.getPrice();
			soda.release();
			System.out.println("잔돈 : " + money);
			money = 0;
			break;
		case 2:
			System.out.println("콜라가 나옵니다.");
			money -= coke.getPrice();
			coke.release();
			System.out.println("잔돈 : " + money);
			money = 0;
			break;
		case 3:
			System.out.println("환타가 나옵니다.");
			money -= fanta.getPrice();
			fanta.release();
			System.out.println("잔돈 : " + money);
			money = 0;
			break;
		default:
		}
	}
	

	
	private void store() {
		System.out.println("========================");
		System.out.println("1. 사이다   2. 콜라   3. 환타"); 
		System.out.print("입고할 음료를 선택하세요 : ");
		int menu = sc.nextInt();
		
		System.out.print("입고 수량 : ");
		int num = sc.nextInt();
		
		switch(menu) {
		case 1:
			soda.store(num);
			break;
		case 2:
			coke.store(num);
			break;
		case 3:
			fanta.store(num);
			break;
		default:
		}
	}
}
