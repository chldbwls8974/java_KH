package day5.practice;

public class RandomEx {

	public static void main(String[] args) {

		// min 부터 max 사이의 랜덤한 정수를 만드는 코드를 작성.
		// Math.random() : 0 이상 1미만의 실수를 랜덤으로 생성
		System.out.println(Math.random());
		
		// 0 <= random < 1
		// 0 * (max - min + 1 ) <= random * (max - min + 1 ) < 1 * (max - min + 1 )
		// 0 <= random * (max - min + 1) < max - min + 1
		// 각 항에 + min
		// min <= random * (max - min + 1 ) + min < max + 1
		
		int min = 1, max = 10;
		int random =(int)( Math.random()*(max - min + 1) +min);
		System.out.println(random);
	}

}
