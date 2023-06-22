package day17.interfaceex;

public interface RunInterface{
	// int num; // final 표기 필수
	// 클래수 상수 >> 클래스를 이용하여 호출
	public final static int NUM= 10; // final이 붙으면 변수는 상수가 되기 때문에 초기값 설정이 필요하다.
	/*public abstract*/ void run();
	
	default void stop() {
		System.out.println("Program stop!");
	}
}