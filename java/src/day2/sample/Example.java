package day2.sample;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		int Kor;
		int Eng;
		int Math;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요.");
		Kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요.");
		Eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요.");
		Math = sc.nextInt();
		
		int sum = add(Kor, Eng, Math);
		double avg = division(sum);
		
		System.out.println("세 과목의 합은 " + sum + "입니다.");
		System.out.println("세 과목의 평균은 " + avg + "입니다.");
	}
	
	public static int add(int n1, int n2, int n3) {
		int result = n1 + n2 + n3;
		return result;
	}
	
	public static double division(int n) {
		double result = n / 3.0;
		return result;
	}
	
}
