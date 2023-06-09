package day8.homework;

import java.util.Scanner;

public class MethodScoreEx {
	public static void main(String[] args) {
	// 성적을 입력받아 학점을 출력하는 코드를 작성
	Scanner sc = new Scanner(System.in);
	System.out.println("Input score");
	int num = sc.nextInt();
	
	System.out.println(score(num));
	System.out.println(getGrade(num));
	
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
	
	
	// if 문과 switch문을 혼합하여 사용할 수 있는 코드
	public static String getGrade(double score) {
		if(score > 100 || score < 0) {
			return "Wrong score!";
		}
		int res = (int)(score/10);
		
		switch(res) {
		case 10: case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
}
