package day5.practice;

public class PrintEvenNumberEx {

	public static void main(String[] args) {
		// 10이하의 짝수 출력
		
		int i = 1;
		
		while (i <= 10) {
			if (i % 2 ==0) {
				System.out.println(i);
			}
			i++;
		}
	}

}
