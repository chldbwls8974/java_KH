package day8.practice;
import java.util.*;
public class MethodEvernNumber {

	public static void main(String[] args) {

		// 정수를 입력받아 짝수인지 아닌지 판별하는 코드를 작성하세요.
		// 단 메서드를 이용할것
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num = sc.nextInt();
		
		System.out.println(even(num));
		evenNum(num);
		
		if(mod(num,2)==0) System.out.println("Even Number (mod)");
		else System.out.println("Odd Number(mod)");
		
		if(isEvenNum(num))System.out.println("Even Number (boolean)");
		else System.out.println("Odd Number(boolean)");

		if(isMultiple(num,2))System.out.println("Even Number (Multiple)");
		else System.out.println("Odd Number(Multiple)");
		
		sc.close();
	}
	
	public static String even(int num1){
		if(num1 %2 == 0)
			return "Even";
		else
			return "Odd";
	}
	
	public static void evenNum(int num1){
		if(num1 %2 == 0)
			System.out.println("Even num");
		else
			System.out.println("Odd num");
	}
	
	/**
	 * num1과 num2가 주어지면 num1을 num2로 나누었을 때 나머지를 알려주는 메서드
	 * 
	 */
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
	
	
	/**
	 * num1과 num2가 주어지면 num1을 num2로 나누었을 때 나머지를 알려주는 메서드
	 * 매개변수 : 판별할 정수
	 * 리턴타임 : 짝수인지 (참) 거짓인지 (거짓) >> boolean
	 * 메서드 명: isEvenNum
	 */
	public static boolean isEvenNum(int num) {
		return num % 2 == 0;
	}
	
	
	/**
	 * num1과 num2가 주어지면 num1이 num2의 배수인지 아닌지 알려주는 메서드
	 * 매개변수 : 두 정수
	 * 리턴타입 : 배수인지 (참) 아니면(거짓) >> boolean
	 * 메서드 명: isMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}

}
