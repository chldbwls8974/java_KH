package day9.classex;

public class Car {
	
	// 멤버변수 (필드)
	private String name; // 차명
	private String company; // 제조사
	private int year; // 연식
	private int speed; 
	private char gear;  // P 주차 R 후진 D 주행 N 중립
	private boolean power; // 전원
	
	// 생성자
	public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'P';
	}
	
	// 메서드
	/** 자동차 정보를 출력하는 메서드
	 * 매개변수: String name, String company, int year >> 이미 알고있는 정보라서 다시 넘겨줄 필요가 없다
	 * 리턴타입: void
	 * 메서드명 : printInfo
	 */
	public void printInfo() {
		System.out.println("자동차 조회");
		System.out.println("제조사	: " + company);
		System.out.println("모델	: " + name);
		System.out.println("연식	: " + year);
		System.out.println("전원	: " + (power?"On":"Off"));
		System.out.println("기어	: " + gear);
		System.out.println("속력	: " + speed);
		
	}
	
	/** 속력이 1 증가 또는 감소하는 메서드
	 * 매개변수: 증가할건지 => boolean positive
	 * 리턴타입: 없음
	 * 메서드명: speedChange
	 */
	
	public void speedChange(boolean positive) {
		// 전원이 꺼져있으면 종료
		if(!power) {
			return;
		}
		
		// 기어가 중립 또는 주차 중이면 종료
		if(gear == 'N' || gear == 'P') {
			return;
		}
		
		if(positive) {
			speed+=1;
		}
		
		else if(speed > 0) speed -= 1;		
	}
	
	
	
	/** 자동차 시동을 켜거나 끄는 메서드
	 * 매개변수: 없음
	 * 리턴타입: void
	 * 메서드명:  turn
	 */
	public void turn() {
		if(!power) {
			power = true;
		}
		else if(gear == 'P') {
			power = false;
		}
	}

	public void setGear(char _gear) {
		gear = _gear;
	}
	
	
}
