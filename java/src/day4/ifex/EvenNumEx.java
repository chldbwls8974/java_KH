package day4.ifex;

import java.util.Scanner;

public class EvenNumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("정수 하나를 입력하시오");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String result = ((num%2 == 0) ? "Even" : "Odd");
		
		System.out.println("입력하신 정수 " + num + "은/는 " + result + "입니다.");
		
		sc.close();
	}

}
