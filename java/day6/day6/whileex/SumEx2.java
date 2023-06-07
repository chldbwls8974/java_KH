package day6.whileex;

import java.util.Scanner;

public class SumEx2 {

	public static void main(String[] args) {

		int i = 0, sum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input number");
		int n = sc.nextInt();
		
		while(i<=n) {
			if (i % 2 == 0) {sum += i;}
			i++;
		}
		
		System.out.println(sum);
		sc.close();
	}

}
