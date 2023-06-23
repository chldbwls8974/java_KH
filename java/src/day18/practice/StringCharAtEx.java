package day18.practice;

import java.util.Scanner;

public class StringCharAtEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input String : ");
		String str = sc.nextLine();
		
		for(char i = 'a'; i <= 'z' ; i++) {
			int count = 0;

			for(int j = 0 ; j < str.length() ; j++) {
				if(i == str.charAt(j)) {
					count++;
				}
				
			}
			if(count!=0) {
				System.out.println("" + i + " : " + count);
			}
		}
		sc.close();
	}
}


