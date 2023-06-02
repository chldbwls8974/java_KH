package day3.practice;

import java.util.Scanner;

public class IfEx1 {

	public static void main(String[] args) {
		// 정수 num을 입력받아서 num이 0인지 음수인지 양수인지 판별하는 코드
		
		System.out.println("정수 하나를 입력하시오");
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if (num==0) {
			System.out.println("정수 " + num + "은 0입니다.");
			}
		else if (num >0) {System.out.println("정수 " + num + "은 양수 입니다.");}
		
		else {System.out.println("정수 "+ num + "은 음수입니다.");}
		
		sc.close();
	}

}
