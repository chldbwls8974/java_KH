package day11.homework;

import java.util.Scanner;

import array.Array;

public class Other {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int com[] = new int[3];
		int user[] = new int[3];
		int min = 1, max = 9;
		int strike = 0, ball = 0;
		
		Array.creatRandomArray2(min, max, com);
		Array.printArray(com);
		
		do {
			System.out.println("user: ");
			for(int i = 0 ; i < user.length ; i++) {
				user[i] = sc.nextInt();
			}
			
			// 사용자 입력 체크
			
			// 판별
			// 스트라이크 개수 판별
			
			// 볼의 개수 판별
			
			// 스트라이크와 볼의 개수에 맞게 출력
			
		}while(strike < 3);
		
	
		
		sc.close();
		
	}
		
	/** 스트라이크 개수를 판별하는 메서드
	 * = > 두 배열에서 같은 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수: 두 배열 int arr1[], int arr2[]	
	 * 리턴타입: 몇개 같은지 int
	 * 메서드명 : Strike
	 */
	/*
	public static int strike(int arr1[], int arr2[]) {
		// 배열 생성이 안된 배열이 하나라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		
		// 배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하기 위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		int count = 0;
		for(int i = 0 ; i < size ; i++) {
			if(arr1[i] == arr2[i]) {
				
			}
		}
	}*/
}







