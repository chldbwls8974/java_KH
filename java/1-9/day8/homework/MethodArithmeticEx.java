package day8.homework;

import java.util.Scanner;

public class MethodArithmeticEx {

	public static void main(String[] args) {

		// 두 정수와 산술 연산자를 입력받아 산술 연산 결과 출력
		// 연산자를 잘못 입력하는 경우는 없다고 가정
		// 메서드 이용
		// 0으로 나누는 경우는 없음
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num1 = sc.nextInt();
		char arith = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		System.out.println( num1 + " " +  arith + " "+ num2 + " = " + result(num1, arith,num2));
				
		sc.close();
	}

	public static double result(int num1, char arith, int num2) {
		if(arith == '+') return num1 + num2;
		else if (arith == '-') return num1 - num2;
		else if (arith == '*') return num1 * num2;
		else if (arith == '/') return (double)num1 / num2;
		else if (arith == '%') return num1 % num2;
		else return 0.0;
	}
	
}

