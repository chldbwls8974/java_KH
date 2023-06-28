package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

public class LotteEx2 {

	public static void main(String[] args) {

		int bonus;
		int min = 1, max = 45;
		HashSet<Integer> lotto = new HashSet<>();
		HashSet<Integer> user = new HashSet<>();
		
		// 로또 번호를 랜덤으로 생성
		while(lotto.size() < 6 ) {
			int r = random(min, max);
			lotto.add(r);
		}
		
		// 보너스 번호 생성
		do {
			bonus = random(min, max);
		}while(lotto.contains(bonus));
		
		System.out.print(lotto);
		System.out.println(bonus);
		
		
		// 사용자 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("input 6 number : ");
		while(user.size()<6) {
			user.add(sc.nextInt());
		}
		
		// 등수 체크
		// 일치하는 개수 확인
		int count = 0;
		for(Integer tmp: user) {
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		// 개수를 이용하여 등수 체크
		switch(count) {
		case 6:
			System.out.println("rank 1"); break;
		case 5:
			if(user.contains(bonus)) {
				System.out.println("rank 2");
			}
			else {
				System.out.println("rank 3");
			}
		 break;
		case 4:
			System.out.println("rank 4"); break;
		case 3:
			System.out.println("rank 5"); break;

			
		}
		
		
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
	
	
}
