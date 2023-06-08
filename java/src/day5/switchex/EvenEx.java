package day5.switchex;

public class EvenEx {

	public static void main(String[] args) {

		// 홀짝 예제를 switch 문으로
		
		int num = 4;
		
		switch(num % 2) {
		case 0:
			System.out.println("Even");
			break;
		default:
			System.out.println("Odd");
		
		}
		
	}

}
