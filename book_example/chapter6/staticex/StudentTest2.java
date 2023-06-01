package staticex;

public class StudentTest2 {

	public static void main(String[] args) {
		Student1 studentLee = new Student1();
		studentLee.setStudentName("이지원");
		System.out.println(studentLee.serialNum);
		System.out.println(studentLee.studentName + "학번: " + studentLee.studentID);
		
		Student1 studentSon = new Student1();
		studentSon.setStudentName("손수경");
		System.out.println(studentSon.serialNum);
		System.out.println(studentSon.studentName + "학번: " + studentSon.studentID);
		
		// 학생 인스턴스를 생성할 때 마다 serialNum 변수의 값을 증가한다.
		// 새로 생성되는 학생마다 가지는 studentID 변수에 증가한 serialNum 값을 복사해 주어 두 학생의 학번이 다르다.
		// 인스턴스 간 공통으로 사용할 값이 필요한 경우 static을 사용하도록 하자.
	}

}
