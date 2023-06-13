package day5.practice;
import java.util.*;

public class MenuEx {

	public static void main(String[] args) {
		// 메뉴를 출력하고 프로그램 종료를 선택하기 전까지느 반복적으로 실행되는 코드
		
		
		Scanner sc = new Scanner(System.in);

		
		int menu = 1;
		while(menu != 3) {
			
			// 메뉴를 출력
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("select menu: ");
			
			// 메뉴를 입력
			menu = sc.nextInt();
			
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
		
		sc.close();
	}

}
