package day3.homework;

import java.util.Scanner;

public class Assign2 {

	public static void main(String[] args) {
		// 성별 판별 문제
		// if문을 이용하여 남성이면 m, 여성이면 w을 출력 
		
		System.out.println("성별을 입력하시오. (남성인 경우 M, 여성인 경우 W)");
		Scanner sc = new Scanner(System.in);
		String gender = sc.next();
		
		if (gender.equals("M")) {
			System.out.println("Are you a women? Men");
		}
		
		else {System.out.println("Are you a women? Women");}
		
		sc.close();
	}

}
