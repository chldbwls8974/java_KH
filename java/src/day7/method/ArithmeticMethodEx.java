package day7.method;

public class ArithmeticMethodEx {

	/** 
	 * 주어진 num1, num2의 합을 알려주는 메소드
	 * 
	 * @param args
	 */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	/**
	 * 주어진 num1, num2의 합을 출력하는 메소드
	 * 더하는 기눙 + 출력하는 기능 >>> 메서드는 하나의 기능만 가지고 있는 것이 좋으므로 딱히 좋은 메서드는 아님.
	 * @param args
	 */
	
	public static void sum2(int num1, int num2) {
		System.out.println(num1+num2);
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
		sum2(1,2);
		System.out.println(sum(1,2));
		System.out.println(minus(1,2));
		System.out.println(time(1,2));
		System.out.println(divide(1,2));
		System.out.println(mod(1,2));
	}

}
