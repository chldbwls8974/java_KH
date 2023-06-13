package day6.nestedloop;

public class MultiplicationTableEx {

	public static void main(String[] args) {

		for(int i = 2 ; i < 10 ; i++) {
			System.out.println("Table " + i + " Start!");
			System.out.println("");
			for (int j = 1 ; j < 10 ; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			System.out.println("===========");
		}
	}

}
