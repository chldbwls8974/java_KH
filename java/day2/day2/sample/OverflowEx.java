package day2.sample;

public class OverflowEx {

	public static void main(String[] args) {
		byte num=127;
		++num;
		
		System.out.println(num); // 오버플로우가 발생하여 음수 출력
		
		//언더플로우
		num=-128;
		--num;
		System.out.println(num);
	}

}
