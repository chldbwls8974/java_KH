package day8.practice;

import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Input number");
		int num = sc.nextInt();
		
		if(isMultiple(num,2)) {
			if(isMultiple(num, 6)) System.out.println("It is a Multiple of 6");
			else System.out.println("It is a Multiple of 2");
		}
		else if(isMultiple(num, 3)) System.out.println("It is a Multiple of 3");
		else System.out.println("Wrong");
		
		sc.close();
		
	}

	
	public static boolean isMultiple(int num1,int num2) {
		return (num1 % num2)==0;
	}
}
