package day2.sample;

public class StringEx {

	public static void main(String[] args) {
		
		// String 클래스는 문자열을 수정하는게 아니라 새로이 생성
		
		String str1 = null; // null이라는 문자열이 아님. null인 경우 null이라고 출력되도록 정해져 있다.
		String str2 = "";
		String str3 = "A";
		String str4 = "안녕하세요";
		
		System.out.println(str1 + "\n"+  str2 + "\n" + str3 + "\n" + str4);
	}

}
