package day10.practice;

public class PointExSol2 {

	public static void main(String[] args) {

		Point2 pt1 = new Point2();
		pt1.print();
		pt1.move(10,20);
		pt1.print();
		
		Point2 pt2 = new Point2(30, 40);
		pt2.print();
	}

}

class Point2{
	// 멤버변수
	/* x좌표, y좌표*/
	
	private int x,y;
	
	//생성자
	public Point2() {}
	
	//생성자 오버로딩. x,y좌표가 주어졌을때 객체 초기화
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	// getter와 setter (메서드에 포함)
	
	/* getter
	 * public 리턴타입 get변수명(){
	 * 		return 변수명;
	 * }
	 * get 변수명에서 변수명의 첫 글자를 대문자로 표현
	 * 리턴타입은 변수의 자료형
	 * 
	 * 
	 * setter
	 * public void set변수명(){
	 * 		this.변수명 = 변수명;
	 * }
	 *  
	 *
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	// 메서드
	/** 현재 좌표를 출력하는 기능
	 * 매개변수: 없음 >> 만약 내 정보가 아니라 남이 알려줘야하면 매개변수로 작성해야함.
	 * 리턴타입: 없음 > void
	 * 메서드명: print
	 */
	public void print() {
		System.out.println(x + " , " + y + "px");
	}
	
	
	
	/** 주어진 x,y 좌표로 이동하는 메서드
	 * => 멤버변수 x,y를 주어진 x,y로 수정하는 메서드
	 * 매개변수: 주어진 x,y
	 * 리턴타입: 없음  >> 콘솔에 출력하거나, 멤버변수의 값을 바꾸는 기능만 있는 경우
	 * 메서드명: move
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
}