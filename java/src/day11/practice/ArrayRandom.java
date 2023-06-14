package day11.practice;

public class ArrayRandom {

	public static void main(String[] args) {

		int [] ran = new int[3];
		int max = 9, min = 1;
		for(int i = 0 ; i < 3 ; i++) {
			ran[i] = (int)( Math.random()*(max - min + 1) +min);
			System.out.println(ran[i]);
		}
	}

}
