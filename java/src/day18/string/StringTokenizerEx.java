package day18.string;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {

		String fruits = "apple,orange,banana";
		
		StringTokenizer st = new StringTokenizer(fruits, ",");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
