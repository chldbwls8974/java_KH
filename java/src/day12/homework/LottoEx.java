package day12.homework;

import java.util.Scanner;

import array.Array;

public class LottoEx {

	public static void main(String[] args) {
		// 로또 번호를 생성하고 사용자가 번호를 입력하면 몇등인지 출력하는 코드
		Scanner sc = new Scanner(System.in);
		int []lotto = new int[7];
		int []user = new int[6];
		Array.creatRandomArray2(1, 45, lotto); // create lotto
		
		System.out.print("Lotto num : ");
		Array.printArray(lotto,1,7);
		System.out.print("Bonus num : ");
		Array.printArray(lotto,0,1);
		System.out.print("input lotto number");
		
		for(int i = 0 ; i < user.length ; i++) {
			user[i] = sc.nextInt();
		}

		System.out.println(getLotto(lotto,user));
		
		sc.close();
	}
	
	// 등수 판별
	public static String getLotto(int arr1[], int arr2[]) {
		int count = 0;
		int bonus = arr1[0];
		
		if(arr1 == null || arr2 == null) {
			return "";
		}
		
		
		// 보너스를 제외한 동일 개수 판별
		for(int i = 1 ; i < arr1.length ; i++) {
			for(int j = 0 ; j < arr2.length ; j++) {
				
				if(arr1[i] == arr2[j]) {
					count++;
				}
			}
		}

		// 2,3 등 판별
		for(int i = 0 ; i < arr2.length ; i++ ) {
			if(bonus==arr2[i]) count+=2;
		}
		
		// 등수 배정
		switch(count) {
		case 7:
			return "2!";
		case 6: 
			return "1!";
		case 5:
			return "3!";
		case 4:
			return "4!";
		case 3:
			return "5!";
		default:
			return "loosing get Lotto!";
			
		}
	}
}
