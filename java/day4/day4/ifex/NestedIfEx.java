package day4.ifex;

import java.util.Scanner;

public class NestedIfEx {

	public static void main(String[] args) {

		// 2,3,6 배수를 중첩 if으로 나타내시오.
		
		System.out.println("input number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 2의 배수
		// 3의 배수
		// 아닌 수로 판별
		if(num%2 == 0) {
			if(num%3 == 0) {System.out.println("6의 배수입니다.");}
			else System.out.println("2의 배수입니다.");
		}
		else if(num%3 == 0) {System.out.println("3의 배수 입니다.");}
		else System.out.println("그 어느 수의 배수도 아닙니다.");
		
		sc.close();
	}

}
