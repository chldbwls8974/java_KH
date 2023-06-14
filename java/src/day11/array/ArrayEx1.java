package day11.array;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {

		/*
		 * 학생들의 국어 성적을 저장하기 위한 배열 생성
		 * 학생들은 총 10명
		 */
		
		double []studentKoreaScore = new double[10];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i <3 ; i++) {
			System.out.print("input score : ");
			studentKoreaScore[i]= sc.nextDouble();
		}
		
		for(int i = 0; i < 3 ; i ++) {
			System.out.println(studentKoreaScore[i]);
		}
		
		/*
		 * 학생 3명의 국어 점수 평균을 구하고 출력하는 코드를 작성하세요
		 */
		
		int sum = 0;
		for(int i = 0 ; i < 3 ; i++) {
			sum += studentKoreaScore[i];
		}
		System.out.println("Average is " + (sum / 3.0));
		sc.close();
	}
	

}
