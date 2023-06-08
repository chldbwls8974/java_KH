package day1.variable;

public class IntExample1 {

	public static void main(String[] args) {
		int num2 = 11;
		int num3 = 0b11; // 2진수
		int num4 = 011; // 8진수
		int num5 = 0x11; // 16진수
		
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		
		// 1234567890123은 int로 표현할 수 없는 큰 숫자
		// The literal of type int is out of range
		// long  타입에 큰 숫자를 저장하는 경우 리터럴에 l 또는 L을 반드시 붙여야함.
		long num6 = 1234567890123l; 
		

	}

}
