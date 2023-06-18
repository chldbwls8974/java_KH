package day13.practice;

import lombok.Data;

@Data
public class Subject {
	
	//멤버변수
	// 학생이름
	// 과목이름
	// 성적
	
	private String student;
	private String subject;
	private int score;
	private double total;
	private double midTerm;
	private double finalTerm;
	private double performance;
	
	
	
	public Subject(String student, String subject, int score) {
		this.student = student;
		this.subject = subject;
		this.score = score;
	}
	
	// 출력하는 메서드
	public void print() {
		System.out.println(student +"의 " + subject +" 점수는 " + score +"입니다." );
		System.out.println("=======================");
	}
	
	// 과목을 입력받는 메서드
	
	
	// 성적을 입력받는 메서
	
}
