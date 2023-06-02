package day3.practice;

import java.util.Scanner;

public class IfEx2 {

	public static void main(String[] args) {
		// 정수 num을 입력받아 홀짝 판명
		

		System.out.println("정수 하나를 입력하시오");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if( num %2 == 0) {
			System.out.println("입력하신 정수 " + num + "은 짝수입니다.");
		}
		
		else {System.out.println("입력하신 정수 " + num + "은 홀수입니다.");}
		
		sc.close();
	}

}
