package day8.homework;

import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {

		// 월을 입력받아 해달하는 월에 맞는 영어를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num = sc.nextInt();
		
		System.out.println(season(num));
		
		sc.close();
	}
	

	public static String season(int num) {
		switch(num) {
		case 1:
			return "jan";
		case 2:
			return "feb";
		case 3:
			return "march";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "Jun";
		case 7:
			return "July";
		case 8:
			return "Aug";
		case 9:
			return "Sep";
		case 10:
			return "Oct";
		case 11:
			return "Novem";
		case 12:
			return "Decem";
		default:
			return "wrong";
		
		
		}
	}

}
