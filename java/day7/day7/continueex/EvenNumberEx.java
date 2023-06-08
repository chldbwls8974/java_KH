package day7.continueex;

public class EvenNumberEx {

	public static void main(String[] args) {

		// continue 문을 이용한 10 이하 짝수 출력
		
		// for을 이용하여
		for (int i = 0 ; i <= 10 ; i++) {
			if(i % 2 != 0)
				continue;
			else System.out.println(i);
		}
	
		System.out.println("============");
		
		// while을 사용한 첫번째 방법
		int  i = 1;
		
		while(i<=10) {
			i++;
			if( i %2 != 0) {
				continue;
			}
			System.out.println(i);
		}
		System.out.println("============");
		
		// while 을 사용한 두번째 방법
		int  j = 0;
		
		while(++j<=10) {
			
			if( j %2 != 0) {
				continue;
			}
			System.out.println(j);
		
		}
	}

}
