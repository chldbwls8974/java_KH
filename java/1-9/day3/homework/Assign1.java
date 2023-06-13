package day3.homework;

import java.util.Scanner;

public class Assign1 {

	public static void main(String[] args) {
		//성별을 입력받아 여성인지 확인하는 코드 (조건연산자사용)
		// input gender
		// 입력: M
		// Are you a women? men
		// Are you a women? women
	
		System.out.println("성별을 입력하시오. (남성인 경우 M, 여성인 경우 W)");
		Scanner sc = new Scanner(System.in);
		String gender = sc.next(); // char gender = sc.next().charArt(0); 
		// String이던 char이던 nextLine();은 불가능
		// nextLine();은 빈문자열도 받기때문에 안됨.
		
		System.out.println("Are you a women? " + (gender.equals("W")? "True":"False" )); // true false가 소문자이면 예약어로 "" 없어도 됨.
		
		sc.close();
	}

}
