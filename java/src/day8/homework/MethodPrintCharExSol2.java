package day8.homework;

public class MethodPrintCharExSol2 {

	public static void main(String[] args) {

		// 재사용이 가능하게 만드는것이 중요
		
		printString("*****");
		printChar('*', 10);
		System.out.println();
		System.out.println(printChar('^',10,'&'));
		System.out.println(printChar('=',10,'\n'));
		
		/*    *
		 *   **
		 *  ***
		 * ****
		 */
		
		int num = 5;
		for(int i = 1; i <=num ; i++) {
			printChar(' ', num-i);
			System.out.print(printChar('*',i,'\n'));
		}
	}

	/** 문자열이 주어지면 주어진 문자열을 출력하고 줄바꿈하는 메서드
	 * 매개변수: 문자열 => String str
	 * 리턴타입: void
	 * 메서명: printString
	 */
	public static void printString(String str) {
		System.out.println(str);
	}
	
	/** 문자와 갯수가 주어지면 주어진 문자를 개수만큼 문자열을 출력하는 메서드
	 * 매개변수: 문자와 개수 => char ch. int count
	 * 리턴타입: void
	 * 메서명: printChar
	 */
	public static void printChar(char ch, int count) {
		for(int i = 0; i < count; i++) {
			System.out.print(ch);
		}
	}
	
	/** 문자와 갯수, 마지막 문자가 주어지면 주어진 문자를 개수만큼 문자열을 출력하고 마지막 문자를 출력하는 메서드,m
	 * 매개변수: 문자와 개수, 마지막 문자 => char ch, int count, char lastch
	 * 리턴타입: 출력된 문자열 => String
	 * 메서명: print
	 */
	public static String printChar(char ch, int count, char lastCh) {
		String str = "";
		for(int i = 0; i < count; i++) {
			str += ch;
	}
		return str += lastCh;
	}
	
}
