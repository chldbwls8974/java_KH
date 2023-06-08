package day7.practice;

public class PrintAlphabetEx2 {

	public static void main(String[] args) {

		char i,j;

		
		for (i = 'a' ; i <= 'z'; i++) {
			for(j = 'a' ; j < i ; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}

}
