package day11.homework;

import java.util.Scanner;

import array.Array;

public class BaseballGameEx {

	public static void main(String[] args) {
		
		int []base = new int[3];
		int []ans = new int[3];
		
		
		Array.creatRandomArray(1, 9, base);
		//Array.printArray(base);

		result(base,ans);
		
	}
		
	// 3O check method
	public static int getCount(int arr1[], int arr2[]) {
		int count = 0;
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		// 배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하기 위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size ; j++) {
				if(arr1[i]!=arr2[j]) count++;	
			}
		}
		return count;
	}
	
	
	// B and S check method
	public static String res(int arr1[], int arr2[]) {
		int s=0, b=0;
		String result="";
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size ; j++) {
				if(arr1[i] == arr2[j]) {
					if(i==j)  s++;
					else if (i!=j)  b++;
				}
			}
		}

		if (s>0 && b>0) {
			result = s + "S" + b + "B";
			return result;
		}
		else if (s > 0) {
			result = s + "S";
			return result;
		}
		else { 
			result = b +"B";
			return result;
		}
	}

	public static void result(int arr1[], int arr2[]) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		do {
		System.out.print("input num: ");
		for(int i = 0 ; i < 3 ; i++) {
			arr2[i] = sc.nextInt();
		}
		
		// 이부분 추가된 내용
		// 사용자 입력 체크
		if(Array.arrayCheck(arr2)) {
			System.out.println("You must not enter the same number!");
			continue;
		}
		
		if(getCount(arr1, arr2)==9) { 
			result = "3O";
			System.out.println(result);
		}
		else {
			System.out.println(res(arr1,arr2)); 
		}
		} while(!res(arr1,arr2).equals("3S") );
		System.out.println("Good!");
		sc.close();
	}
	
}
