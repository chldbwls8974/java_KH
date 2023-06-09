package day8.practice;

import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num = sc.nextInt();
		
		season(num);
		
		sc.close();
		
	}

	
	public static void season(int num) {
		switch(num) {
		case 1: case 2: case 12:
			System.out.println("Winter");
			break;
		case 3: case 4: case 5:
			System.out.println("Spring");
			break;
		case 6: case 7: case 8:
			System.out.println("Summer");
			break;
		case 9: case 10: case 11:
			System.out.println("Fall");
			break;
		default:
			System.out.println("Wrong");
			
		}
	}
	
	
	// case문 사용시 return을 만나면 바로 빠져나가기 때문에 break가 필요없다.
	public static String season2(int num) {
		switch(num) {
		case 1: case 2: case 12:
			return "winter";
		case 3: case 4: case 5:
			return "Spring";
		case 6: case 7: case 8:
			return "Summer";
		case 9: case 10: case 11:
			return "Fall";
		default:
			return "winter";
			
		}
	}
}
