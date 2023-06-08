package day7.homework;

public class StarEx {

	public static void main(String[] args) {
		// 다이아몬드 만들기

		for (int i = 1 ; i <= 5 ; i++) {
			
			for(int j = 1 ; j <=5 - i ; j++) { System.out.print(' ');}
			
			for(int j = 1 ; j <= 2* i -1 ; j++) { System.out.print('*');}
	
			System.out.println();	
		}
		
		for (int i = 5 ; i >= 1 ; i--) {
			
			for(int j = 1 ; j <=5 - i ; j++) { System.out.print(' ');}	
			
			for(int j = 1 ; j <= 2 * i -1 ; j++) { System.out.print('*');}
			
			System.out.println();				
		}
	}

}
