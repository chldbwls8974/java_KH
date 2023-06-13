package day10.thisex;

public class StudentMain {

	public static void main(String[] args) {

		Student1.printCount();
		
		Student1 std1 = new Student1(1,1,1, "Tomas");
		Student1.printCount();
		
		Student1 std2 = new Student1(1,1,2, "John");
		Student1.printCount();

		//std2.studentCount = 1;
		//System.out.println(std1.studentCount); // studentCount 는 static이라서 이곳 클래스와 아래 클래스가 공유하고 있다.
		// 그리고, std2가 바뀌어도 std1도 바뀐다.
		
		std1.print();
		// Student1.print(); // 에러 발생. static 이 print에는 안붙어서
		std2.print();
	}

}

class Student1{
	private static int studentCount;
	private int grade, classNum, number;
	private String name;
	
	
	// 이 생성자는 매개변수가 있고, 매개변수의 이름이 멤버변수와 같기 때문에
	// 멤버 변수 호출 시 this를 반드시 붙여야함
	public Student1(int grade, int classNum, int number, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
		studentCount++;
	}
	
	// 기본 생성자는 매개변수가 없기 때문에 this를 안써도 됨
	public Student1() {
		// 멤버변수와 이름이 닽은 지역 변수를 만들 수 도 있다.  (비추천)
		// int grade = 1;
		// this.grade = grade;
		
		this(1,1,1,""); // 코드가 시작하는 첫 라인에 생성자 호출. 순서가 바뀌면 에러가 생김.
		// 
		
		/*
		grade = 1;
		classNum = 1;
		number = 1;
		name = "";
		*/
		
		
	}
	
	
	// 객체 메서드
	public void print() {
		System.out.println("==============================");
		System.out.println("grade		: " + grade);  // 객체 변수 사용 가능
		System.out.println("classNum	: " + classNum); 
		System.out.println("number		: " + number); 
		System.out.println("name		: " + name); 
		// 클래스 변수 사용 가능
		//System.out.println("count		: " + studentCount);
		// 클래스 메서드 사용 가능
		//printCount();
	}
	
	// 클래스 메서드
	public static void printCount() {
		// 클래스 변수 사용 가능
		System.out.println("Registered student count : " + studentCount);
		
		// 객체 변수 사용 불가능(직접)
		// grade = 1;
		// 객체 메서드 사용 불가능(직접)
		// print();
		// 객체를 생성 후 호출해서 사용 가능
		Student1 std1 = new Student1();
		std1.name = "hong";
		std1.print();
	}
}
