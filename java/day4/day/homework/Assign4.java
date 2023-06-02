package day.homework;

import java.util.Scanner;

public class Assign4 {

	public static void main(String[] args) {

		// 정수가 짝수이면 2를 더하고
		// 홀수 이면 1을 더한후 num을 출력하는 코드
		
		System.out.println("입력하는 정수가 짝수이면 2를 더하고, 홀수이면 1을 더하는 코드입니다.");
		System.out.println("정수 num을 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
	
		System.out.println("입력하신 정수는 " + num + "이고, " + ((num%2 == 0)?"짝수":"홀수") + "이므로, " 
		+ "결과는 " + ((num%2 == 0)? (num + 2) :(num +1)) + "입니다.");
		
		sc.close();
	
	}

}
