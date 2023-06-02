package day.homework;

import java.util.Scanner;

public class Assign3 {

	public static void main(String[] args) {
		// 세 변의 길이를 정수로 받아 삼각형을 만들 수 있는지 확인하는 코드
		// 세 변 중 작은 두 변의 길이의 합이 큰 변의 길이보다 커야 삼각형을 만들 수 있다.
		
		System.out.println("세 변의 길이를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if(num1>=num2 && num1>=num3) {
			if (num1 < (num2 + num3)) {System.out.println("입력하신 세 변의 길이로 삼각형을 만들 수 있습니다.");}
			else System.out.println("삼각형을 만들 수 없습니다.");
		}
		else if(num2>=num1 && num2>=num3) {
			if (num2 < (num1 + num3)) {System.out.println("입력하신 세 변의 길이로 삼각형을 만들 수 있습니다.");}
			else System.out.println("삼각형을 만들 수 없습니다.");
		}
		else if(num3>=num1 && num3>=num2) {
			if (num3 < (num1 + num2)) {System.out.println("입력하신 세 변의 길이로 삼각형을 만들 수 있습니다.");}
			else System.out.println("삼각형을 만들 수 없습니다.");
		}
		else System.out.println("삼각형을 만들 수 없습니다.");
		
		sc.close();
	}

}
