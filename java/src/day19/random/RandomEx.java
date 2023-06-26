package day19.random;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {

		/*
		 * min~max 사이의 랜덤한 정수:Math.random 사용
		 */
		
		int min = 1, max = 9;
		int r = (int)(Math.random()*(max-min+1)+min);
		System.out.println(r);
		
		
		/*
		 * min~max 사이의 랜덤한 정수:Random 클래스 사용
		 */
		Random random = new Random(); // 매번 다른 종자값(현재시간)을 이요하기 때문에 난수가 매번 달라짐
		int r2 = random.nextInt();
		System.out.println(r2);
		
		int r3 = random.nextInt(max - min + 1) + min;
		System.out.println(r3);
	}

}
