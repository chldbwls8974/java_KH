package day4.ifex;

import java.util.Scanner;

public class MultipleEx2 {

	public static void main(String[] args) {

		// 입력받은 정수가 2의 배수이면 2의 배수라고, 3의 배수, 6의 배수, 아니면 아니라고 출력
		
		System.out.println("input number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num%6 == 0) {System.out.println("6의 배수입니다.");}
		else if(num%2 == 0) {System.out.println("2의 배수입니다.");}
		else if(num%3 == 0) {System.out.println("3의 배수입니다.");}
		else {System.out.println("2,3,6 그 어떤수의 배수도 아닙니다.");}
		
		// 6의 배수가 아닌 2의 배수만 찾기 위해 2의 배수이지만 3의 배수가 아닌 정수를 확인. 순서 상관없는 버전.
		//if(num%2 == 0 && num%3 != 0) {System.out.println("2의 배수입니다.");}
		//else if(num%3 == 0 && num % 2 !=0) {System.out.println("3의 배수입니다.");}
		//else if(num%6 == 0) {System.out.println("6의 배수입니다.");}
		//else {System.out.println("2,3,6 그 어떤수의 배수도 아닙니다.");}
		
		sc.close();
	}

}
