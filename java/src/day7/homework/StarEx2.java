package day7.homework;

public class StarEx2 {

	public static void main(String[] args) {
		int num = 7;
		
		for (int i = 1 ; i <= num ; i++) {
			int half = (num +1)/2;
			
			if(i<=half) {
				for(int j = 1 ; j <= half - i ; j++) {
					System.out.print(" ");
				}
				for(int j = 1 ; j <= 2*i -1 ; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
			
			else {
				/*
				for(int j = 1 ; j >= i-half ; j++) {
					System.out.print(" ");
				}
				
				for(int j = 1 ; j <= 2*(num - i ) + 1  ; j++) {
					System.out.print('*');
				}*/
				for(int j = i-half ; j >=1 ; j--) {
					System.out.print(" ");
				}
				
				for(int j = 5 ; j >= 1   ; j-=2 ) {
					System.out.print('*');
				}	
				System.out.println();
				
			}
		}
	}

}
