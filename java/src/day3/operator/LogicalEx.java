package day3.operator;

public class LogicalEx {

	public static void main(String[] args) {
			int score = 80;
			// score가 80 이상 90 미만
			System.out.println(score + "점은 B학점인가? " + (score >= 80 && score < 90));
			
			int age = 21;
			boolean isAdult = age >=20;
			System.out.println(age + "세는 미성년자인가? " +  !isAdult);
			
			boolean hasIdCard = true;
			boolean hasDriverCard = false;
			System.out.println("토익을 볼 수 있을까요? " + (hasIdCard || hasDriverCard));
	}

}
