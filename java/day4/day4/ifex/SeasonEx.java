package day4.ifex;

import java.util.Scanner;

public class SeasonEx {

	public static void main(String[] args) {
		
		System.out.println("월을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num >= 3 && num <=5) {
			System.out.println( num + "월은 봄입니다.");
			}
		else if (num >=6 && num <=8) {System.out.println( num + "월은 여름입니다.");}

		else if (num >=9 && num <=11) {System.out.println( num + "월은 가을입니다.");}
		
		else if (num == 12 || num ==1 || num ==2 ) {System.out.println( num + "월은 겨울입니다.");}
		
		else {System.out.println("잘못된 월.");}
		
		sc.close();
	}

}
