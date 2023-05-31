package day2.sample;

public class ConstantEx {

	public static void main(String[] args) {
		final int MAX_AGE;
		MAX_AGE = 100;
		// MAX_AGE = 101; 에러 발생, 1번 초기화 한 후 수정하려고 했기 때문.
		System.out.println(MAX_AGE);
		
		// int totlCount; // 지역변수는 자동으로 초기화 되지 않으며, 초기화 하지 않으면 에러가 발생한다.
		
	}

}
