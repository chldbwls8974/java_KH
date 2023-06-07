package day6.homework;

import java.util.Scanner;

public class DisjointEx {
	public static void main(String[] args) {
	// 두 정수를 입력받아 두 정수가 서로소인지 판별하는 코드
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("int number A and B");
		int a = sc.nextInt(), b = sc.nextInt();
		int i = 1, result = 0;
		
		while(a >= i) { // 큰 수와 작은 수 사이의 수들은 어차피 최대공약수가 될 수 없기때문에 조건에 크게 신경 쓸 필요 없음.
			if(a % i== 0 && b % i == 0) {
				result++;
			}
			i++;
		}
		if(result ==1) {
			System.out.println("Disjoint!");}
		else
			System.out.println("Not disjoint!");
		sc.close();
	}
}
