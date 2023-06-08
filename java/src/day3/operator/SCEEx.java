package day3.operator;

public class SCEEx {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println("IS " + str + " equal to abc " + (str != null && str.equals("abc")));
		System.out.println("IS " + str + " equal to abc " + (str.equals("abc") && str != null  ));

		
	}

}
