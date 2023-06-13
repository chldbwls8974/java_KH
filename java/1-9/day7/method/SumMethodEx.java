package day7.method;

public class SumMethodEx {
	

	
	public static void main(String[] args) {
		// 두 정수의 합을 구하는 함수(메서드)를 만드세요
		
		int num1=1, num2=2;
		int res= sum(num1,num2);
		System.out.println(res);
	}
	
	/** public static 리턴타입 메서드명(매개변수들){
		return xx;		
		}

	 * 기능: 두 정수가 주어지면 두 정수의 합을 알려주는 메서드
	 *리턴 타입: 두 정수의 합 => int
	 * 메서드 명: sum
	 * 매개변수: 두 정수 => int num1, int num2
	 * return
	 **/

	public static int sum(int num1, int num2) {
		int res = num1 + num2;
	return res;

}


}
