package homework.manager.student.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Score {
	//private int kor, math, eng;
	//private int score;
	
	/* 변수 :각 과목과 과목 당 성적 >> 
	 * 성적은 한 학기에 두번
	 * 
	 * 
	 * 메서드
	 * 성적의 총 합 >> 평균까지 계산 가능
	 * 성적 출력
	 * 성적 검색
	 * */
	
	private int kor;
	private int eng;
	private int math;
	
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Score other = (Score) obj;
//		return eng == other.eng && kor == other.kor && math == other.math;
//	}
//
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(eng, kor, math);
//	}
	
	public void update(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void print() {
		System.out.println("성적 출력");
		System.out.println("국어 성적 : " + kor);
		System.out.println("영어 성적 : " + eng);
		System.out.println("수학 성적 : " + math);
		System.out.print("점수 총합 : " + (kor + eng + math) + " 	" + "점수 평군 : " + (double)(kor + eng + math)/3);
		
	}

}

