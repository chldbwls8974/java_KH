package day5.practice;
import java.util.*;

public class DivisorEx {

	public static void main(String[] args) {

		// 정수 num 의 약수를 구하는 코드를 작성하세요.
		
		System.out.println("input number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i = 1;
		
		while (i <= num) {
			if (num %i == 0) {
			System.out.println(i);}
			i++;
		}
		
		sc.close();
	}

}
