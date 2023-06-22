package day17.object;

import java.util.Objects;

import lombok.Data;

public class ObjectEx {

	public static void main(String[] args) throws CloneNotSupportedException {
		Point1 pt1 = new Point1(10,20);
		System.out.println(pt1);
		System.out.println(pt1.toString());
		
		Point1 pt11 = new Point1(10,20);
		System.out.println(pt1==pt11);
		System.out.println(pt1.equals(pt11));
		
		System.out.println("=======");
		
		Point2 pt2 = new Point2(30,40);
		System.out.println(pt2);
		
		Point2 pt21 = new Point2(30,40);
		System.out.println(pt2==pt21);
		System.out.println(pt2.equals(pt21));

		System.out.println("=======");

		Point2 pt22 = (Point2)pt2.clone(); // 다운캐스팅 >> (클래스명)를 반드시 추가
		System.out.println(pt2==pt22); // 주소는 다르지
		System.out.println(pt2.equals(pt22)); // 값은 같지 >> 복제 성공!!
		System.out.println(pt22);
	}

}

@Data // toString(), equals(), hashcode() 오버라이딩 , getter, setter를 자동 생성
class Point1{
	private int x,y;
	
	public Point1(int x, int y) {
		this.x = x;
		this.y =y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

class Point2 implements Cloneable{
	private int x,y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y =y;
	}
	
	@Override
	public String toString() {
		return "[x=" + x + "," + y + ")";
	}


	@Override
	public boolean equals(Object obj) {
		// 주소를 비교  
		if (this == obj)
			return true;
		
		// 없는 객체
		if (obj == null)
			return false;
		
		// 내 클래스와 비교할 객체의 클래스가 다른 경우
		if (getClass() != obj.getClass())
			return false;
		
		// 비교할 객체의 클래스가 같은 클래스인 경우
		Point2 other = (Point2) obj;
		
		// 멤버들을 각각 비교해서 같은지를 확인
		return x == other.x && y == other.y;
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}