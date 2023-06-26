package day19.homework;

import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {

		// 산술연산하는 메서드를 만들고 테스트하는 코드
		// 예외처리 이용
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input");
		 
		
		try {
			
			int num1 = sc.nextInt();
			String op = sc.next();
			int num2 = sc.nextInt();
			calculate(num1, op, num2);
			
		}catch(Exception e) {
			System.out.println("Exception!");
			
		}finally {
			System.out.println("FINISHED!!");
		}
		
		sc.close();
	}

	public static void calculate(int num1, String op, int num2) throws Exception{
		switch(op) {
		case "+":
			System.out.println(num1 + num2);
			break;
		case "-":
			System.out.println(num1 - num2);
			break;
		case "*":
			System.out.println(num1 * num2);
			break;
		case "%":
			System.out.println(num1 % num2);
			break;
		case "/":
			System.out.println(num1 / num2);
			break;
		default:
			System.out.println("Not Operation");
		}
	}
}
