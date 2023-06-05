package day5.whileex;

public class HelloWorldEx {

	public static void main(String[] args) {
		// Hello World를 10번 출력하는 코드
		/* 반복횟수 10번 : 10번, 1번 부터 10번까지 1씩 증가
		 * => 변수의 초기값: 1
		 * => 조건식: 10까지 => 10 보다 작거나 같을 때 까지
		 * => 증가식 : 1씩 증가
		 * 규칙성: Hello world를 출력
		 * => 실행문
		 * */
		 
		int i = 1;
		
		while(i<=10) {
			System.out.println("hello world");
			i++;
		}
	}

}
