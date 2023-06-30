package homework.manager.student.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Score {

	private int kor;
	private int eng;
	private int math;
	
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public void update(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	
	public String toString() {
		return "국어 성적 : " + kor + "\n" + "영어 성적 : " + eng + "\n" + "수학 성적 : " + math + "\n"
	+ "점수 총합 : " + (kor + eng + math) + " 	" + "점수 평군 : " + (double)(kor + eng + math)/3;
	}

}

