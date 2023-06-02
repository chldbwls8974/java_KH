package day2.homework;

import java.util.*;

public class ScanAssign1 {

	// 정수 두개와 산술 연사자를 입력받아 출력하시오.
	// 입력: 1 + 2
	// 출력: 1 + 2
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수와 산술연산자를 입력하세요.");
		//String str = sc.next(); 이걸로 하면 공백을 기준으로 한 글자(단어)만 나옴.
		String str = sc.nextLine();
		System.out.println(str);
		
		sc.close();
	}

}
