package day7.practice;

import java.util.Scanner;

public class LCMEx2 {

	public static void main(String[] args) {

		// 두 정수 입력 받아 두 정수의 최소 공배수를 출력
		// 최소공배수는 두 정수의 곱보다 작거나 같다는 점을 이용
		// 반복횟수는 num1부터 num1 * num2 까지 num1 씩 증가
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("intput number A and B");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i;
		
		for(i = a ; ;i+=a ) {
			if (i % b == 0)	
				break;
		}
		
		System.out.println(i);
	}

}
