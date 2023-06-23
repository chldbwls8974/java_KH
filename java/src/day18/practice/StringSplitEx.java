package day18.practice;

import java.util.Scanner;

public class StringSplitEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		System.out.print("input : ");
		String str = sc.nextLine();
		
		
		String str1[] = str.split(" ");
		
		System.out.println("word : " + str1.length);
		
		sc.close();
	}

}
