package day4.ifex;

import java.util.Scanner;

public class MultiplerEx1 {

	public static void main(String[] args) {
		
		// 정수 num을 입력받아 num이 2의 배수인지 아닌지 판별
		
		System.out.println("input number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num%2 == 0) {System.out.println("2의 배수입니다.");}
		else {System.out.println("2의 배수가 아닙니다");}
		
		sc.close();
	}

}
