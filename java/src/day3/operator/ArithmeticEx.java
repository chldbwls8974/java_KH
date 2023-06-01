package day3.operator;

public class ArithmeticEx {

	public static void main(String[] args) {
		
		// byte + int, char + int의 결과는 int라서 byte나 char에 저장 불가능
		// 따라서 형변환 필수
		byte num1 = 3;
		num1 = (byte)(num1 + 5);
		
		char ch = 'A';
		System.out.println(ch);
		ch =(char)(ch + 1);
		System.out.println(ch);
		
	}

}
