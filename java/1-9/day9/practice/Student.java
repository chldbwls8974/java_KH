package day9.practice;

public class Student {
	/*
	 * 학생 클래스와 성적 클래스를 만들어 출력하는 예제
	 * 학생 클래스에서는
	 * 이름, 학년, 반, 학번, 주소 
	 */
	
	// 멤버변수
	private static int serialNum = 1000;
	private String name;
	private int grade;
	private int residentyear;
	private int classNum;
	private String studentNum;
	
	
	// 생성자
	public Student(String name,int residentyear, int grade, int classNum) {
		this.name = name;
		this.residentyear = residentyear;
		this.grade = grade;
		this.classNum = classNum;
		serialNum++;
		studentNum = ""+ residentyear + grade + classNum + serialNum;
	}
	


	/*
	public static int getSerialNum() {
		int i = 10;
		return serialNum;
	}
	public static void setSerialNum(int serialNum) {
		Student.serialNum = serialNum;
	}*/
	
	
	// 출력 메서드
	public void showInfo() {
		System.out.println(name + "은 " + grade + "학년 " + classNum +"반 이고, 학번은 " + studentNum + "입니다." );
	}
	

}
