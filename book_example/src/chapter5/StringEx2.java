package chapter5;

public class StringEx2 {

	public static void main(String[] args) {
		String str="";
		String str2="";
		char op = '+';
		int num1= 1, num2=2;
		
		str = num1 + op + num2 + "=" + (num1 + num2); // '+'가 43임.
		System.out.println(str);
		
		//위의 문제를 해결하기 위해 "" 추가. 빈문자열과 num1이 계산되어 문자열 1
		//문자열 1과 + 이 더해져서 문자열 1 +
		// ...
		str2 = "" +  num1 + op + num2 + "=" + (num1 + num2);
		System.out.println(str2);
	}

}
