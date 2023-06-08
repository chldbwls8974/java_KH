package day7.method;

public class ArithmeticMethodEx {

	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int minus(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int time(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double divide(int num1, int num2) {
		return (double)num1/num2;
	}

	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
	
	
	public static void main(String[] args) {
		System.out.println(sum(1,2));
		System.out.println(minus(1,2));
		System.out.println(time(1,2));
		System.out.println(divide(1,2));
		System.out.println(mod(1,2));
	}

}
