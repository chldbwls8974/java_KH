package day5.switchex;

import java.util.Scanner;

public class SeasonEx {

	public static void main(String[] args) {
		System.out.println("input number 1 to 12");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
	/*
		switch(num) {
		case 1:
			System.out.println("Winter");
			break;
		case 2:
			System.out.println("Winter");
			break;
		case 3:
			System.out.println("Spring");
			break;
		case 4:
			System.out.println("Spring");
			break;
		case 5:
			System.out.println("Spring");
			break;
		case 6:
			System.out.println("Summer");
			break;
		case 7:
			System.out.println("Summer");
			break;
		case 8:
			System.out.println("Summer");
			break;
		case 9:
			System.out.println("Fall");
			break;
		case 10:
			System.out.println("Fall");
			break;
		case 11:
			System.out.println("Fall");
			break;
		case 12:
			System.out.println("Winter");
			break;
		default:
			System.out.println("Wrong");
*/
		
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
		
		sc.close();
	}

}
