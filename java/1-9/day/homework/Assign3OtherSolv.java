package day.homework;

import java.util.Scanner;

public class Assign3OtherSolv {

	public static void main(String[] args) {
		// 세 변의 길이를 정수로 받아 삼각형을 만들 수 있는지 확인하는 코드
		// 세 변 중 작은 두 변의 길이의 합이 큰 변의 길이보다 커야 삼각형을 만들 수 있다.
			
		int max;
		
		System.out.println("세 변의 길이를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//삼각형 가능 여부를 확인 및 출력
		// 세 변 중 가장 큰 변의 길이를 계산
		
		if(a>b) {
			if(a>c) {
				max= a;
			}
			else max = c;
		}
		
		else if(b>c) {
			max = b;
		}
		
		else {max = c;}
		
		
		// 조건 연산자를 이용하여 한 줄로 작성하면 
		// max = a > b ? (a > c ? a : c) : ( b > c ? b: c);
		// 다음과 같이 표현이 가능하다.
		// 작은 두 변의 함 >= max
		// 세변의 합 - max == 작은 두변의 합
		// 세변의 합에서 max 를 뺀 값이 max보다 크면 삼각형이라고 출력
		
		if ( a + b +  c - max > max) {
			System.out.println("able");
		}
		else System.out.println(" unable");
		
		sc.close();

	}

}
