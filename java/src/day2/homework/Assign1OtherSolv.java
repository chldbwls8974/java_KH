package day2.homework;
import java.util.*; // 단축키 ctrl + shift + 5

public class Assign1OtherSolv {

	public static void main(String[] args) {

		// 정수 두개와 산술 연사자를 입력받아 출력하시오.
		// 입력: 1 + 2
		// 출력: 1 + 2
		
		int num1, num2;
		char operator;
		
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("두 정수와 산술연산자를 입력하세요. (예: 1+2)");
		 num1=sc.nextInt();
		 operator = sc.next().charAt(0);
		 num2=sc.nextInt();
		 
		 System.out.println(""+ num1 + operator + num2);
		 
		 sc.close();
		
		
		
	}

}
