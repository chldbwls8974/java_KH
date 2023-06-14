package day11.practice;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {

		// 정수 num의 약수들을 배열에 저장하는 코드를 작성하세요. 약수는 최대 10개까지만 출력
		
		Scanner sc = new Scanner(System.in);
		int []arr= new int [10];
		System.out.println("input num: ");
		int num = sc.nextInt();

		A(num, arr);
		
		System.out.println(" ======== ");
		for(int tmp : arr) {
			System.out.println(tmp);
		}
		
		
		sc.close();
	}

	public static void A(int a, int arr[]) {
		int  k = 0;
		for (int i = 1; i <= a ; i++) {
			if(a % i == 0) {
				arr[k] = i;
				k++;
				if(k == arr.length) break;
			}
		}
		// 빈칸 0은 안나옴
		for (int i = 0 ; i < k ; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
}
