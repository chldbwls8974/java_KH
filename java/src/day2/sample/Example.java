
package day2.sample;
import java.util.Scanner;
public class Example {

	public static void main(String[] args) {
		int Kor = 0;
		int Eng = 0;
		int Math = 0;
		int sum = add(Kor, Eng, Math);
		double avg = division(sum / 3);
		
		System.out.println("세 과목의 합은" + sum + "입니다.");
		System.out.println("세 과목의 평균은" + avg + "입니다.");
	}
	
	public static int add(int n1, int n2, int n3) {
		int result = n1 + n2 + n3;
		return result;
	}
	
	public static double division(int n) {
		double result = n / 3;
		return result;
	}
	
}
