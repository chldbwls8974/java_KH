package day19.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두정수와 산술연산자를 입력하시오");
		try {
		int num1 = sc.nextInt();
		String op = sc.next();
		int num2 = sc.nextInt();

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
			System.out.println("Not operator!");
		}
		}catch(InputMismatchException e){
			System.out.println("Wrong input!");
		}
		catch(ArithmeticException e) {
			System.out.println("Not operation!");
		}catch(Exception e) {
			System.out.println("Exception!");
		}
		System.out.println("EXIT!");
		test1();
		test2();

		sc.close();
	}
	
	
	public static void test1() {
		// finally 는 리턴으로 메서드를 종료하더라도 반드시 들려서 실행하는 코드
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception");
			return;
		}finally {
			System.out.println("Method Test1");
		}
	}
	
	public static void test2() {
		// finally가 없으면 리턴으로 메서드가 종료되면 return 아래 코드는 실행되지 않는다
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception");
			return;
		}
		System.out.println("Method Test2");
	}

}
