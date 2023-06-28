package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

import lombok.Data;

@Data
public class LottoEx {

	public static void main(String[] args) {

		// set을 이용한 로또 문제
		
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> set1 = new HashSet<>();
		int []user = new int[6];
		
		while(set1.size() < 6) {
			int r = random(1,45);
			set1.add(r);
		}
		
		System.out.println(set1);

		System.out.print("input lotto number");
		for(int i = 0 ; i < user.length ; i++) {
			user[i] = sc.nextInt();
		}
		
		getLotto(set1, user);
		sc.close();
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()* (max - min + 1) + min);
	}
	

	public static String getLotto(HashSet<Integer> set1, int arr1[]) {		
		for(int i = 0 ; i < arr1.length ; i++) {
			if(set1.contains(arr1[i])) {
				return "good";
			}
		}
		return "x";
		

	}

	
}
