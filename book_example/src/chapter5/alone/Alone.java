package chapter5.alone;

public class Alone {

	public static void main(String[] args) {
	
		int num1 = 30;
		int num2= 5;
		
		int sum = add(num1, num2);
		System.out.println(num1 + "+" + num2 + "=" + sum);
		
		int minus = minus(num1, num2);
		System.out.println(num1 + "-" + num2 + "=" + minus);
		
		int times = time(num1, num2);
		System.out.println(num1 + "*" + num2 + "=" + times);
	}
	
	public static int add(int n1, int n2) {
		int result= n1 + n2;
		return result;
	}
	
	public static int minus(int n1, int n2) {
		int result= n1 - n2;
		return result;
	}
	
	public static int time(int n1, int n2) {
		int result= n1 * n2;
		return result;
	}
	
	
}
