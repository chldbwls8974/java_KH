package day6.practice;

public class PrimeNumbersEx {

	public static void main(String[] args) {

		// 2부터 100사이의 모든 소수를 출력하는 코드
		
		
		for(int i = 2 ; i <= 100 ; i++) {
			int count = 0;    // 위치 신경쓰자
			for(int j = 1 ; j <= i ; j++) {
				if ( i % j == 0) count++;
			}
		
			if( count == 2 ) {System.out.println(i);}
		}
	}

}
