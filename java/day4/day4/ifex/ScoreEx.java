package day4.ifex;

import java.util.Scanner;

public class ScoreEx {

	public static void main(String[] args) {

		// 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		// A: 90 <= =<100
		// B: ,,, 
		// 60미만 F
		
		System.out.println("input score");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		if (score >= 90 && score <= 100) {System.out.println("A");}
		else if (score >= 80 && score <= 90) {System.out.println("B");}
		else if (score >= 70 && score <= 80) {System.out.println("C");}
		else if (score >= 60 && score <= 70) {System.out.println("D");}
		else if (score < 60) {System.out.println("F");}
		else {System.out.println("wrong score");}
		
		sc.close();
	}

}
