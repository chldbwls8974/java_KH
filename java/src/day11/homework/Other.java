package day11.homework;

import java.util.Scanner;

public class Other {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int []base = new int[3];
		int []ans = new int[3];
		
		String result = "";
		
		randomArray(1, 9, base);
		print(base);
		
		do {
		System.out.print("input num: ");
		for(int i = 0 ; i < 3 ; i++) {
			ans[i] = sc.nextInt();
		}
		if(getCount(base, ans)==9) { 
			result = "3O";
			System.out.println(result);
		}
		else {
			System.out.println(res(base,ans)); 
		}
		} while(!res(base,ans).equals("3S") );
		System.out.println("Good!");
		
		sc.close();
		
	}
	
	
	// method 
	
	// print method
	public static void print(int arr[]) {
		for(int num : arr) {
			System.out.print(num);
		}
		System.out.println();
	}
	
	// 3O check method
	public static int getCount(int arr1[], int arr2[]) {
		int count = 0;
		for(int i = 0 ; i < arr1.length ; i++) {
			for(int j = 0 ; j < arr1.length ; j++) {
				if(arr1[i]!=arr2[j]) count++;	
			}
		}
		return count;
	}
	
	
	// B and S check method
	public static String res(int arr1[], int arr2[]) {
		int s=0, b=0;
		String result="";
		for(int i = 0 ; i < arr1.length ; i++) {
			for(int j = 0 ; j < arr1.length ; j++) {
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

	
	// Methods to prevent duplication
	public static boolean contains(int arr[], int num, int count) {
		for(int i = 0 ; i < count ; i++) {
			if(num == arr[i]) {
				return true;
			}
		}
		return false;

	}
	
	public static void randomArray(int min, int max, int arr[]) {
		if(arr == null) return;

		if(max - min + 1 < arr.length) return;
		
		
		int count = 0; 
		while(count < 3) {
			
			int ran = (int)( Math.random()*(max - min + 1) +min);
			if(!contains(arr,ran,count)) {
				arr[count] = ran;
				count++;
			}
		}
	}
}
