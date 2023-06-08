package day6.dowhileex;

import java.util.Scanner;

public class PrintMenuEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int menu; // 입력받은 menu가 3이 아니면 반복
		
		do {
			// 메뉴를 출력
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("select menu: ");
				
			// 메뉴를 입력
			menu = sc.nextInt();
			
			// 선택한 메뉴에 따른 출력문 실행
			switch(menu){
			case 1:
				System.out.println("program Start!");
				break;
			case 2:
				System.out.println("program Save!");
				break;
			case 3:
				System.out.println("program Exit!");
				break;
			}
		}
			while(menu != 3); {}
		
		
		sc.close();
	}
}
