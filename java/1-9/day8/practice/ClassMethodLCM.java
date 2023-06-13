package day8.practice;

import java.util.Scanner;

public class ClassMethodLCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num1 = sc.nextInt(), num2 = sc.nextInt();
		
		int gcd = MethodGCDEx.gcd(num1, num2);
		
		System.out.println(num1 + " and " + num2 + " of LCM is a " + num1 * num2 / gcd);
		
		sc.close();
	}

}
