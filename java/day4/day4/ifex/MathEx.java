package day4.ifex;

import java.util.Scanner;

public class MathEx {

	public static void main(String[] args) {
		int num1, num2;
		String operator;
		
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("두 정수와 산술연산자를 입력하세요. (예: 1+2)");
		 num1=sc.nextInt();
		 operator = sc.next();
		 num2=sc.nextInt();
		 
		 /*
		 if(operator.equals("+")) { result = num1 + num2; }
		 else if(operator.equals("-")) { result = num1 - num2;}
		 else if(operator.equals("*")) { result = num1 * num2;}
		 else if(operator.equals("/")) { double result = (double)num1 / num2; }
		 else if(operator.equals("%")) { result = num1 % num2;}
		 
		 System.out.println("" + num1 + operator + num2 + " = " + result);
		 */
		 
		
		 if(operator.equals("+")) { System.out.println("" + num1 + operator + num2 + " = " + (num1+num2));}
		 else if(operator.equals("-")) { System.out.println("" + num1 + operator + num2 + " = " + (num1-num2));}
		 else if(operator.equals("*")) { System.out.println("" + num1 + operator + num2 + " = " + (num1*num2));}
		 else if(operator.equals("/")) {  System.out.println("" + num1 + operator + num2 + " = " + ((double)num1/num2));}
		 else if(operator.equals("%")) {  System.out.println("" + num1 + operator + num2 + " = " + (num1%num2));}
		 else {System.out.println("다시 입력하세요.");}
		 
		 sc.close();
	}

}
