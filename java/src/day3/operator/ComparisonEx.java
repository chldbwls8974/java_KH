package day3.operator;

public class ComparisonEx {

	public static void main(String[] args) {
		System.out.println("1 > 2 :" + (1>2));
		System.out.println("1 < 2 :" + (1<2));
		System.out.println("1 >= 2 :" + (1>=2));
		System.out.println("1 <= 2 :" + (1<=2));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		
		System.out.println();
		System.out.println("str1 == str2 : " + (str1==str2));
		System.out.println("str1 == str3 : " + (str1==str3));
		System.out.println("str2 == str3 : " + str2.equals(str3)); // 리터럴이 아닌 문자열을 비교하기 위해서는 equals 를 사용한다.
	}

}
