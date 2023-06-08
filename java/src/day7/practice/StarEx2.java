package day7.practice;

public class StarEx2 {

	public static void main(String[] args) {

		int i,j;
		
		// 좌측 정렬 상하대비 삼각형
		for (i = 5 ; i >= 1 ; i--) {
			for(j = i ; j >= 1 ; j--) {
				System.out.print('*');
			}
			System.out.println();
	
		}
		System.out.println("==============");

		
		// 좌측 정렬 삼각형
		
		for (i = 1 ; i <= 5; i++) {
			for(j = 1 ; j <= i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("==============");
			
		
		// 우측 정렬 삼각형
		for (i = 1 ; i <= 5; i++) {
			for(j = 1 ; j <=5- i ; j++) {
				System.out.print(' ');
			}
			for(j = 1 ; j <= i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}


