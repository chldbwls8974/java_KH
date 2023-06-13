package day10.practice;

public class RectEx {

	public static void main(String[] args) {

		// 그림판의 사각형을 그리기 위한 클래스를 생성하고 테스트하는 코드를 작성
		
		Rect rt1 = new Rect(3,5,6,6);
		rt1.print();
		rt1.move(2, 4);
		rt1.print();
	}

}

class Rect{
	private int x,y,w,h;
	
	public Rect() {}

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
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

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	
	public void print() {
		System.out.println("Start Edge is " + x + " , " + y +"px");
		System.out.println("Width of rect is " + w);
		System.out.println("Height of rect is " + h);
		System.out.println("Area of rect is " + w*h);
		System.out.println("======================");
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void change(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	
	// 두번째 방법
class Rect2{
	
	// 멤버변수
	private Point2 leftUp, rightDown;

	// 생성자
	public Rect2(Point2 leftUp, Point2 rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
	}
	
	public Rect2(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		leftUp = new Point2(leftUpX, leftUpY);
		rightDown = new Point2(rightDownX, rightDownY);
	}
	
	public void print() {
		System.out.print("LU point : " );
		leftUp.print();
		System.out.println("RD point :");
		rightDown.print();
	}

	public void move(int x, int y) {
		int dx = leftUp.getX()- x ;
		int dy = leftUp.getY() - y;
		//rightDownX = rightDown.getX() - dx;
		
	}
	
}
}
