package day11.homework;

import java.util.Scanner;

public class BaseballGameEx {

	public static void main(String[] args) {

		// 숫자 야구 게임
		// 1 ~ 9 사이의 중복되지 않은 세 수 를 맞추는 게임
		// 규칙
		// B: 같은 숫자가 있지만 위치가 다름
		// S: 같은 숫자가 있고 위치가 같음
		// 30 쓰리아웃 : 일치하는 숫자가 하나도 없음
		// 정답 입력하면 3S
		Scanner sc = new Scanner(System.in);
		
		int max = 9, min = 1;
		int []base = new int[3];
		int []ans = new int[3];
		
	
		
		System.out.println("input num");
		for(int i = 0 ; i < 3 ; i++) {
			base[i] = (int)( Math.random()*(max - min + 1) + min);
			ans[i] = sc.nextInt();
		}
		
		print(base);
		print(ans);
		System.out.println(res(base,ans));		
		
		sc.close();
		
	}
	
	// 배열 출력 메서드
	public static void print(int arr[]) {
		for(int num : arr) {
			System.out.print(num);
		}
		System.out.println();
	}
	
	// 비교 메서드
	public static String res(int arr1[], int arr2[]) {
		for(int i = 0 ; i < arr1.length ; i++) {
			for(int j = 0 ; j < arr1.length ; j++) {
				if(arr1[i]==arr2[j]) {
					if(i==j) return "S";
					else return "B";
				}
				
			}
		}
		return "";
	}
}
