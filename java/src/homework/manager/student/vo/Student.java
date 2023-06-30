package homework.manager.student.vo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import lombok.Data;

@Data
public class Student {

	private Scanner sc = new Scanner(System.in);
	/* 한 학생에게 필요한 정보를 생각하도록 한다.
	 * 학년 반 번호 학번
	 * 이름
	 * 성적
	 * 주소
	 * 면담일지 >> 면담일지 추가, 수정, 삭제
	 * */
	
	private int grade, classNum, num;
	private String name;
	private String address;
	private ArrayList<Interview> interviewNote = new ArrayList<>();
	private ArrayList<Score> score = new ArrayList<>();
	private Stream<Score> scoreStream = score.stream();
	private Stream<Interview> interviewStream = interviewNote.stream();
	
	public Student(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	// 업데이트
	public void addStudent(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}

	// 성적 추가
	public void addScore() {
		System.out.println("성적을 입력하세요. (국어, 영어, 수학)");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		Score tmp = new Score(kor, eng, math);
		score.add(tmp);
		
		System.out.println("전산 등록 완료!");
	}
	
	// 성적 수정
	public void modifyScore() {
		
	}
	
	// 성적 조회 >> 수정해야함
	public void printScore() {
		scoreStream = score.stream();
		scoreStream.forEach(name -> System.out.println(name));
	}
	
	// 면담 추가
	
	public String toString() {
		return  grade  + "학년 " + classNum  + "반 " + num + "번 "  +" 이름: " + name + "  " +  " 주소: " + address;
	}
	
	

}
