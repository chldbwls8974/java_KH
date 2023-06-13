package day10.practice;

public class PointEx {

	public static void main(String[] args) {
		
		// 좌표의 점을 관리하는 클래스를 만들고 테스트하는 코드
		// 관리한다는게 몬말일가
		
		Point point1 = new Point(1,1);
		Point point2 = new Point(5,1);
		Point point3 = new Point(10,156);
		Point point4 = new Point();
		
		point1.print();
		point2.print();
		point3.print();
		point4.print();
		
	}

}

/*
 * 클래스의 접근제어자가 public으로 올 수 있는 조건
 * - 파일명과 클래스명이 같아야 public을 붙일 수 있다.
 * 같은 패키지에 같은 이름의 클래스가 있으면 안됨.
 */

class Point{
	
	private int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public Point() { 
		//this(0,0); // 굳이 입력 안해도 됨. 0으로 자동 초기화
	}
	
	public void print() {
		System.out.println(" =============== ");
		System.out.println("x point is " + x);
		System.out.println("y point is " + y);
	}
}
