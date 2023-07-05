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
	private ArrayList<Interview> interviewNote = new ArrayList<>();
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
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public void addStudent(int grade, int classNum, int num, String name, String address) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.address = address;
	}

	public void addScore() {
		System.out.println("input score (kor, eng, math)");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		Score tmp = new Score(kor, eng, math);
		score.add(tmp);
		
		System.out.println("Success!");
	}
	
	public void modifyScore() {
		
	}
	
	public void printScore() {
		Stream<Score> scoreStream = score.stream();
		scoreStream.forEach(name -> System.out.println(name));
	}
	
	public String toString() {
		return  grade  + " " + classNum  + " " + num + " "  + "  " + name + "  " +  " address : " + address;
	}
	
	

}
