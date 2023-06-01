package day3.operator;

public class ComparisonEx {
	
	/*※ 문자열을 비교할때에는 되도록이면 equals를 사용하도록 한다.
	  ※ null과 비교하는 경우 리터럴인지 아닌지와 관계없이 == !=를 이용하여 비교가능하다.
	 * */

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
		System.out.println("str3 == null : " + str3 == null); // null과 비교하는 경우에는 리터럴 여부에 관계없이 비교 가능.
	}

}
