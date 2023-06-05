package day5.homework;
import java.util.*;

public class TeamLeader {

	public static void main(String[] args) {

		// 30명의 학생이 있는 반에서 1번부터 연속된 번호를 가진 3명의 학생이 1조가 되도로 나누었다.
		// 이때 가장 큰 번호인 학생이 조장이 된다.
		// 학생 번호가 주어졌을 때 조장인지 조원인지 판별하는 코드를 작성하세요.
		// input student number
		
		
		// 3의 배수는 팀장, 아닌 수는 팀원
		
		//switch 문
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input student number");
		int num = sc.nextInt();
		
		switch(num % 3 ) {
		case 0:
			System.out.println("input student number " + num + " is a TeamLeader.");
			break;
			
		case 1:
			System.out.println("input student number " + num + " is a just Team Member.");
			break;
			
		case 2:
			System.out.println("input student number " + num + " is a just Team Member.");
			break;
			
		
		}
		
		
		sc.close();
	}

}
