package day18.practice;

import java.util.regex.Pattern;

public class RegexEx1 {

	public static void main(String[] args) {

		// 입력받은 문자열이 http:// 또는 https://로 시작하는지 확인하는 정규 표현식
		
		String str = "http://www.naver.com";
		String regex = "^https?://[a-zA-Z\\.]+$";
		boolean result = Pattern.matches(regex, str);
		System.out.println(str + " : " + result);
		
	}

}
