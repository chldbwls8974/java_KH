package day12.practice;

import lombok.Data;

/* �븳 �떒�뼱瑜� 愿�由ы븯�뒗 �겢�옒�뒪
 * �떒�뼱
 * �쑜�뱾
 * */
@Data // getter, setter , toStting, equals를 추가
public class Word{
	//硫ㅻ쾭蹂��닔
	private String title;
	private String meaning[];
	private int meaningCount; // �쑜�씠 ���옣�맂 媛쒖닔
	
	
	// �깮�꽦�옄
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];
		this.meaning[0] = meaning;
		meaningCount++;
	}
	
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5];
	}
	
	// 蹂듭궗�깮�꽦�옄
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];
		// this.meaning = w.meaning; // �뼍�� 蹂듭궗
		for(int i = 0 ; i < w.meaningCount ; i++) {
			meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	
	
	
	
	// 硫붿꽌�뱶
	/** �떒�뼱�� �쑜�쓣 異쒕젰�븯�뒗 硫붿꽌�뱶
	 * 留ㅺ컻蹂��닔: �뾾�쓬
	 * 由ы꽩���엯: void
	 * 硫붿꽌�뱶紐�: print
	 */
	public void print() {
		System.out.println("Word: " + title);
		System.out.println("meaning: ");
		for(int i = 0 ; i < meaningCount ; i++) {
				System.out.println(i + 1 + ". " + meaning[i]);
		}
	}
	
	/** �쑜�쓣 異붽��븯�뒗 硫붿꽌�뱶
	 * 留ㅺ컻蹂��닔: String meaning
	 * 由ы꽩���엯: void
	 * 硫붿꽌�뱶紐�: addMeaning
	 */
	public void addMeaning(String meaning) {
		if(meaningCount == this.meaning.length) {
			System.out.println("It's all filled.");
			return;
		}
		this.meaning[meaningCount]= meaning;
		meaningCount++;
	}
	
	/** �쑜�쓣 �젣嫄고븯�뒗 硫붿꽌�뱶
	 * 留ㅺ컻蹂��닔: �젣嫄고븷 �쑜�쓽 踰덊샇 int number
	 * 由ы꽩���엯: void
	 * 硫붿꽌�뱶紐�: deleteMeaning
	 */
	public void removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			System.out.println("I can't work");
			return;
		}
		// num-1踰덉�遺��꽣 �븯�굹�뵫 �떦寃⑥��꽌 �뜮�뼱�벐湲�
		for(int i = num-1 ; i < meaningCount-1 ; i++) {
			meaning[i]=meaning[i+1];
		}
		// 留덉�留됱뿉 �벝紐⑥뾾�뒗 �뜲�씠�꽣瑜� 吏���
		meaning[meaningCount-1]= null;
		// �젣嫄곕릱�쑝硫� �쑜 媛쒖닔 �븯�굹 以꾩엫.
		meaningCount--;
		
	}
	
	/** 수정할 뜻의 번호와 수정할 뜻이 주어지ㅕㄴ 뜻을 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 수정할 뜻의 번지, 수정할 뜻 > intmeaningNum, String meaning
	 * 리턴타입 : 수정 여부 > boolean
	 */
	public boolean updateMeaning(int meaningNum, String meaning) {
		// 수정할 뜻의 번호가 잘못된 경우
		if(meaningNum > meaningCount||meaningNum <= 0) {
			return false;
		}
		// meaninNum은 1부터 , index는 0부터
		this.meaning[meaningNum-1] = meaning;
		return true;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
