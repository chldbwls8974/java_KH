package day7.practice;
import java.util.Scanner;
public class LCMEx {

	public static void main(String[] args) {

		// 두 정수 입력 받아 두 정수의 최소 공배수를 출력
		// 최소공배수는 두 정수의 곱보다 작거나 같다는 점을 이용
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("intput number A and B");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i;
		
		for(i = 1 ; ; i++) {
			if ( i % a == 0 && i % b == 0)	
				break;
		}
		
		System.out.println(i);
	}
}
