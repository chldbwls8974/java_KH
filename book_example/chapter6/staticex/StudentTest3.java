package staticex;

public class StudentTest3 {

	public static void main(String[] args) {
		Student1 studentLee = new Student1();
		studentLee.setStudentName("이지원");
		// static은 인스턴스가 아닌 클래스명으로도 참조가 가능하기 때문에 studentLee가 아니가 Student1로 발루올 수 있다.
		System.out.println(Student1.serialNum); 
		// 반면에 학생 이름과 아이디는 static 변수가 아니기 때문에 studentLee로만 불러올 수가 있다.
		System.out.println(studentLee.studentName + "학번: " + studentLee.studentID);
		
		Student1 studentSon = new Student1();
		studentSon.setStudentName("손수경");
		System.out.println(Student1.serialNum);
		System.out.println(studentSon.studentName + "학번: " + studentSon.studentID);
	}

}
