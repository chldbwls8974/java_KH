package day6.whileex;

import java.util.Scanner;

public class SumEx {

	public static void main(String[] args) {

		// 1 부터 n까지 합을 구하는 코드 출력
		
		
		int i = 0, sum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input number");
		int n = sc.nextInt();
		
		while(i<=n) {
			sum += i;
			i++;
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
 