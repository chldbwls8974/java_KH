package day8.homework;

import java.util.Scanner;

public class MethodScoreEx {
	public static void main(String[] args) {
	// 성적을 입력받아 학점을 출력하는 코드를 작성
	Scanner sc = new Scanner(System.in);
	System.out.println("Input score");
	int num = sc.nextInt();
	
	System.out.println(score(num));
	
	sc.close();
	}
	
	public static char score(int num) {
		if(num>=0 && num <= 100) {
			if(num < 60) return 'F';
			else if(num < 70) return 'D';
			else if(num < 80) return 'C';
			else if(num < 90) return 'B';
			else return 'A';
	
		}
		return ' ';
	}
}
