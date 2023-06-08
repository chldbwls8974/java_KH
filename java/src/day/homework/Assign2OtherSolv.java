package day.homework;
import java.util.Scanner;

public class Assign2OtherSolv {

	public static void main(String[] args) {
		// 두 정수를 입력받아 두 정수 중 큰 수 출력
		
		System.out.println("두 정수를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int max;
		
		if(num1 >= num2) {
			max= num1;
		}
		
		else max = num2;
		
		System.out.println("큰 수 는 " + max + "입니다.");
		
		
		
		
		sc.close();
	}

}
