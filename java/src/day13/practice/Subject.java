package day13.practice;

import lombok.Data;

@Data
public class Subject {
	
	//�������
	// �л��̸�
	// �����̸�
	// ����
	
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
	
	// ����ϴ� �޼���
	public void print() {
		System.out.println(student +"�� " + subject +" ������ " + score +"�Դϴ�." );
		System.out.println("=======================");
	}
	
	// ������ �Է¹޴� �޼���
	
	
	// ������ �Է¹޴� �޼�
	
}
