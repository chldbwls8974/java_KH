package day5.practice;

import java.util.Scanner;

public class PrimeNumberEx {

	public static void main(String[] args) {

		// 정수 num을 입력받아 소수인지 아닌지 판별
		
		System.out.println("input number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = 1;
		int count = 0;
		
		
		// 규칙성: i가 num의 약수이면 약수의 개수 count 증가
		// num을 i로 나누었을때 나머지가 0과 같다면 약수의 개수 count 1증가
		// 반복문 종료 후 count가 2 이면 소수라고 출력, 아니며 소수가 아님이라고 출력
		
		while (i <= num) {
			if (num % i == 0) {
				count++;
			}
			i++;
		}
		
		if ( count ==2) {System.out.println(num + "  is a primenumber.");}
		sc.close();
	}

}
