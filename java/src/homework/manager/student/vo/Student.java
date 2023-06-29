package homework.manager.student.vo;

import lombok.Data;

@Data
public class Student {

	
	/* 학생 관리 
	 * 입학 : 추가
	 * 전학 
	 * 		입 : 추가
	 * 		출 : 삭제
	 * 졸업 : 삭제
	 * 진학 : 수정
	 * */
	
	/* 학년 반 번호 학번
	 * 이름
	 * 성적
	 * 주소
	 * 면담일지
	 * */
	
	static int serialNum = 1000;
	private int grade, classNum, num;
	private String studentId; // 한번 만들어지면 학생이 진학을 하여도 수정되지 않는 값
	private String name;
	private String address;
}
