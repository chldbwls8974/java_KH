package homework.manager.student.vo;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public Student(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}
	
	// 업데이트
	public void addStudent(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}
	
	/*
	// 학생정보 출력 (면담일자는 자동 출력 X, 응답 받아 출력
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("주소 : " + address);
		System.out.println("성적표");
		System.out.println("성젹표를 열람하시겠습니까?");
			char ans = sc.next().charAt(0);
			if(ans == 'y') {
				printScore();
			}
		System.out.println("면담 일지");
		System.out.print("면담 일지를 열람하시겠습니까?");
			ans = sc.next().charAt(0);
			if(ans == 'y') {
				printInterview();
			}
	}*/
	

	// 학생 면담일자 출력
	private void printInterview() {
		for(Interview tmp : interviewNote) {
			System.out.println(tmp);
		}
	}
	
	// 학생 성적 출력
	private void printScore() {
		for(Score tmp : score) {
			System.out.println(tmp);
		}
	}
	

}
