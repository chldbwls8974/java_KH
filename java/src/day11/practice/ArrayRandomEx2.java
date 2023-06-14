package day11.practice;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		int [] ran = new int[5];
		int max = 9, min = 1;
		int i = 0;
		
	
		for(int j = 0 ; j < 5 ; j++) {
			ran[j] = (int)( Math.random()*(max - min + 1) +min);
		}
		
		for(int j = 0 ; j < 5 ; j++) {
			for(int k = 0 ; k < j ; k++) {
				if(ran[j]==ran[k]) {
					ran[k] = (int)( Math.random()*(max - min + 1) +min);
				}
			}
		}
		
		for(int j = 0 ; j < 5 ; j++) {
			System.out.println(ran[j]);
		}

		
	}
	

}
