package chapter5;

public class StudentTest2 {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.studentName = "안연수";
		
		Student student2 = new Student();
		student2.studentName = "안승연";
		
		// 참조 변수 값 출력 == 클래스 이름@주소값 , 주소값 == 해시코드 값
		System.out.println(student1);
		System.out.println(student2);
		
		// 도트를 이용하여 학생 이름 출력
		System.out.println(student1.studentName);
		
		
	}

}
