package day12.practice;


/* 한 단어를 관리하는 클래스
 * 단어
 * 뜻들
 * */
public class Word{
	//멤버변수
	private String title;
	private String meaning[];
	private int meaningCount; // 뜻이 저장된 개수
	
	
	// 생성자
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
	
	// 복사생성자
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];
		// this.meaning = w.meaning; // 얕은 복사
		for(int i = 0 ; i < w.meaningCount ; i++) {
			meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	
	
	
	
	// 메서드
	/** 단어와 뜻을 출력하는 메서드
	 * 매개변수: 없음
	 * 리턴타입: void
	 * 메서드명: print
	 */
	public void print() {
		System.out.println("Word: " + title);
		System.out.println("meaning: ");
		for(int i = 0 ; i < meaningCount ; i++) {
				System.out.println(i + 1 + ". " + meaning[i]);
		}
	}
	
	/** 뜻을 추가하는 메서드
	 * 매개변수: String meaning
	 * 리턴타입: void
	 * 메서드명: addMeaning
	 */
	public void addMeaning(String meaning) {
		if(meaningCount == this.meaning.length) {
			System.out.println("It's all filled.");
			return;
		}
		this.meaning[meaningCount]= meaning;
		meaningCount++;
	}
	
	/** 뜻을 제거하는 메서드
	 * 매개변수: 제거할 뜻의 번호 int number
	 * 리턴타입: void
	 * 메서드명: deleteMeaning
	 */
	public void deleteMeaning(int num) {
		if(num > meaningCount || num < 1) {
			System.out.println("I can't work");
			return;
		}
		// num-1번지부터 하나씩 당겨와서 덮어쓰기
		for(int i = num-1 ; i < meaningCount-1 ; i++) {
			meaning[i]=meaning[i+1];
		}
		// 마지막에 쓸모없는 데이터를 지움
		meaning[meaningCount-1]= null;
		// 제거됐으면 뜻 개수 하나 줄임.
		meaningCount--;
		
		
	}
	
	
	
	
	
	
}
