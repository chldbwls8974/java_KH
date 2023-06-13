package day6.practice;

import java.util.Scanner;

public class AverageEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("국어, 영어, 수학 성적의 평균을 구하는 코드입니다.");
		
		Scanner sc = new Scanner(System.in);
		
		char ans = 'y';
		
		while(ans != 'n' && ans == 'y') {
			System.out.println("국어, 영어, 수학 순서대로 성적을 입력하시오.");
			
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			
			System.out.println((kor + eng + math)/ 3.0);
			System.out.println("continue? (y/n)");
			ans = sc.next().charAt(0);
		}
		 System.out.println("EXIT");
		 
		 sc.close();
		
		
	}

}
