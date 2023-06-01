package singleton;

public class Company {
	// 2단계: 클래스 내부에 static으로 유일한 인스턴스 생성하기
	// 프로그램에서 사용할 인스턴스 하나는 필요하기 때문에 Company 클래스 내부에서 하나의 인스턴스 생성
	// 이 인스턴스가 프로그램 전체에서 사용하는 유일한 인스턴스
	// private으로 선언하여 외부에서 접근을 제한해야 인스턴스 오류 방지
	private static Company instance = new Company();
	
	// 1단계: 생성자를 private로 만들기
	// 싱글톤 패턴에서는 생성자를 반드시 명시적으로 만들고 그 접근 제어자를 private로 지정해야함.
	// 외부 인스턴스를 생성할 수 없음.
	// Company 클래스 내부에서만 이 클래스의 생성을 제어 할 수 있음.
	private Company() {} 
	
	
	// 3단계: 외부에서 참조할 수 있는 public get() 메서드 만들기
	// private으로 선언한 유일한 인스턴스를 외부에서 사용할 수 있도록 설정
	// 인스턴스를 반환하는 메서드를 static으로 선언해주는 이유는 getInstance() 메서드는 인스턴스 생성과 상관없이 호출할 수 있어야하기 때문
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
