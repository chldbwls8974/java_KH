package day3.practice;
import java.util.*;

public class Ex2 {

	public static void main(String[] args) {

		//성적을 입력받아 입력 받은 성적이 60점 이상인지 확인하는 코드를 작성하세요.
		// 예: input score: 
		// 65
		// Do you pass 65 point? true
		// 예: input score:
		// 45
		// Do you pass 45 point? false
		
		System.out.println("input score: ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		System.out.println("Do you pass " + score + " point? " + ((score >= 60) ? "pass" : "fail") );
		
		sc.close();
	}

}
