package day3.ifex;

import java.util.*;

public class IfEx1 {

	public static void main(String[] args) {
		// 정수 num을 입력받고 num이 0이면 0입니다 라고 출력하는 코드를 작성하시오.
		
		System.out.println("정수 하나를 입력하시오");
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if (num==0) {
			System.out.println("정수 " + num + "은 0입니다.");
			}
		else {System.out.println("정수 " + num + "은 0이 아닙니다.");}
		
		sc.close();
	}

}
