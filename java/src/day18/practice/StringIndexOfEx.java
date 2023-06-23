package day18.practice;

public class StringIndexOfEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Hello world";
		int count = 0;
		
		
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.indexOf("l",i)==i) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}
