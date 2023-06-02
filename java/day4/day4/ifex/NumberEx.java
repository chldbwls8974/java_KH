package day4.ifex;

import java.util.Scanner;

public class NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 양수이면 positive number라고 출력하고
		 * num 이 음수하면 negative number 라고 출력하고
		 * num이 0이면 0으로 출력하는 코드
		 * */
		
System.out.println("input number");
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("positive number.");
			}
		else if (num < 0) {System.out.println("negative number.");}
		
		else {System.out.println(0);}
		
		sc.close();
	}

}
