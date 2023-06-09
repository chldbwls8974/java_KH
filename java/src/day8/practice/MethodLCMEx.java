package day8.practice;

import java.util.Scanner;

public class MethodLCMEx {

	public static void main(String[] args) {

		// 최대공약수를 이용하여 최소 공배수 찾는 문제
		// A = g*a, B = g*b 최대 공약수(g)를 알때 최소공배수(l)는
		// l = A * B / g
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num1 = sc.nextInt(), num2 = sc.nextInt();
		
		int gcd= gcd(num1,num2);
		int lcm= lcm1(num1,num2);
		
		System.out.println("LCM is a " + num1*num2/gcd);
		System.out.println("LCM is a " + lcm);
		
		sc.close();
		
	}
	
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	public static int gcd(int num1, int num2) {
		for(int i = num1 ; i>= 1; i--) {
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				return i;
			}
		}
		return 1;
	}
	
	// 최대 공약수를 이용하지 않고 최소 공배수 찾는 코드
	public static int lcm1(int num1, int num2) {
		for(int i = num1 ; i<= num1 * num2 ; i+=num1) {
			if(isMultiple(i, num2)) {
				return i;
			}
		}
		return num1 * num2;
	}
}
