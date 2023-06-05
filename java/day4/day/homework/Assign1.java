package day.homework;

import java.util.Scanner;

public class Assign1 {

	public static void main(String[] args) {
		// 국,영,수 성적을 입력받아 평균을 출력하는 코드
		
		System.out.println("국어, 영어, 수학 성적의 평균을 구하는 코드입니다.");
		System.out.println("국어, 영어, 수학 순서대로 성적을 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		System.out.println("세 과목 성적의 평균은 " + (kor + eng + math)/3.0 + " 입니다.");
		
		sc.close();

	}

}
