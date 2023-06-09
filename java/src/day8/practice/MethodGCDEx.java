package day8.practice;

import java.util.Scanner;

public class MethodGCDEx {

	public static void main(String[] args) {

		// 최대 공약수 찾는 코드
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num1 = sc.nextInt(), num2 = sc.nextInt();
		//int i = 1, result = 0;
		/*
		while(num1 >= i) {
			if (isMultiple(num1, i) && isMultiple(num2, i)) {result = i;}
			i++;
		}
		
		System.out.println(result + " is a GCD");
		*/
		
		int gcd= gcd(num1, num2);
		
		System.out.println(gcd);
		
		
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
}
