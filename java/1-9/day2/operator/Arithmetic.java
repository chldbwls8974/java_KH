package day2.operator;

public class Arithmetic {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2; // 1 나누기 2의 결과가 0이어서, 1.0/2로 바꾸어 0.5가 나오게 함.
		int mod = num1 % num2;
		
		System.out.println(""+num1 + "+" + num2 + "=" + sum);
		System.out.println(""+num1 + "-" + num2 + "=" + sub);
		System.out.println(""+num1 + "*" + num2 + "=" + mul);
		System.out.println(""+num1 + "/" + num2 + "=" + div);
		System.out.println(""+num1 + "%" + num2 + "=" + mod);
		
		
	}

}
