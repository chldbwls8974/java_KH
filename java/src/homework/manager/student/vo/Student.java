package homework.manager.student.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import lombok.Data;

@Data
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2882501458266876640L;
	private transient  Scanner sc = new Scanner(System.in);
	
	private int grade, classNum, num;
	private String name;
	private String address;
	private ArrayList<InterviewNote> interviewNote = new ArrayList<>();
	private ArrayList<Score> score = new ArrayList<>();
	//private Stream<Score> scoreStream = score.stream();
	//private Stream<Interview> interviewStream = interviewNote.stream();
	
	public Student(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}
	
	public Student() {}

	public void addStudent(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}

	public void addScore() {
		System.out.println("input grade and semester");
		int grade = sc.nextInt();
		int semester = sc.nextInt();
		
		System.out.println("input score (kor, eng, math)");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		
		Score tmp = new Score(grade,semester,kor, eng, math);
		score.add(tmp);
		
		System.out.println("Success!");
	}
	
	public void modifyScore() {
		System.out.println("input grade and semester you want to modify");
		int grade = sc.nextInt();
		int semester = sc.nextInt();
		
		// 학년과 학기가 같은 경우의 인덱스를 찾아...
	}
	
	public void printScore() {
		// 입력받은 학생의 점수만 출력 >> filter >> controller에서 수정
		Stream<Score> scoreStream = score.stream();
		scoreStream.forEach(name -> System.out.println(name));
	}
	
	public String toString() {
		return  grade  + " " + classNum  + " " + num + " "  + "  " + name + "  " +  " address : " + address;
	}

	public void printInterview() {
		Stream<InterviewNote> interviewStream = interviewNote.stream();
		interviewStream.forEach(name -> System.out.println(name));
		
	}

	public void addInterview() {
		System.out.println("input interview information");
		sc.nextLine();
		String interview = sc.nextLine();
		//InterviewNote note = new InterviewNote();
	}
	
	

}
