package day13.homework.vo;


public class VocabularyNote {

	private Word wordList[]; 

	private int wordCount; 


	public VocabularyNote() {
		wordList = new Word[10];
	}
	
	public VocabularyNote(Word wordList[]) {
		int size = wordList.length > 10 ? wordList.length : 10; 
		
		this.wordList = new Word[size];
		
		for(int i = 0 ; i < wordList.length ; i++) {
			this.wordList[i]= new Word(wordList[i]);
		}
		wordCount = wordList.length;
	}
	
	

	public void print() {
		System.out.println("=============");
		for(int i = 0 ; i < wordCount ; i++) {
			wordList[i].print();
			System.out.println("=============");
		}
	}
	

	
	/** 단어가 주어지면 단어장에 추가하는 메서드( 단어 객체를 넘겨주는 경우)
	 * 매개변수:  단어 (단어 객체) >> Word word
	 * 리턴타입: 없음
	 * 메서드명 : insert
	 */
	public void insert (Word word) {
		//단어장에 단어가 다 찼을 경우를 막기 위해 
		if(wordCount==wordList.length) {
			System.out.println("Vocabulary note is full!");
			return;
		}
		// 깊은 복사를 위해 Word의 복사 생성자를 이용하여 새 단어를 생성한 후 추가
		wordList[wordCount++] = new Word(word);
		
	}
	
	
	/** 단어와 뜻이 주어지면 단어장에 추가하는 메서드( 단어와 뜻을 넘겨주는 경우)
	 * 없는 단어이면 새로 단어를 추가하고,
	 * 있는 단어이면 뜻만 새로 추가하는 메서드
	 * 매개변수: 단어와 뜻>>Stirng title, String meaning  
	 * 리턴타이 > 없음
	 * 메서드명: insert
	 */
	public int insert (String title, String meaning) {
		//단어장에 단어가 다 찼을 경우를 막기 위해 
		if(wordCount==wordList.length) {
			// System.out.println("Vocabulary note is full!");
			return 0;
		}
		
		int index = indexOf(title);
		// 엇는 단어이면 새 단어로 추가
		if(index == -1) {
			// 단어와 뜻을 이용해 단어 객체를 생성한 후 단어장에 추가
			wordList[wordCount++] = new Word(title, meaning);
			return 1;
		}
		// 있는 단어인 경우 뜻 추가
		wordList[index].addMeaning(meaning);
		return -1;
	}
	
	
	
	/** 단어가 주어지면 다어장에서 삭제하고 삭제 여부를 알려주는 메서드
	 * 매개변수 : 삭제할 단어  String title
	 * 리턴타입 : 삭제 여부 boolean
	 * 메서드명: delete
	 */
	
	public boolean delete(String title) {
		// 단어가 어디있는지 찾아야함
		int index = indexOf(title);
		//단어가 단어장에 없으면 알림 메세지 출력 후 종료
		if( index == -1) {
			//System.out.println("No words found");
			return false;
		}
		
		// 찾은 위치부터 한칸씩 당겨옴.
		for(int i = index ; i < wordCount -1 ; i++) {
			wordList[i] = wordList[i+1];
			
		}
		// e단어의 개수를 하나 줄여ㅇ줌.
		wordCount--;
		
		// 마지막 단어를 비워줌(null)
		wordList[wordCount]= null;
		return true;
	}
	
	
	
	/** 단어가 주어지면 단어가 있는 위치를 알려주는 메서드
	 * 단어가 없으면 관례적으로 -1을 리턴
	 * 매개변수: 단어 > String title
	 * 리턴타입: 위치 > 정수  int
	 * 메서드명: indexOf
	 */
	public int indexOf(String title) {
		//단어장에 등록된 단어들을 조회
		for(int i= 0; i < wordCount ; i++) {
			// 단어가 같으면 i번지를 리턴
			if(wordList[i].getTitle().equals(title)) {
				return i;
			}
		}
		// 여기까지 오면 일치하는 단어가 없다
		return -1;
	}
	
	
	
	/**단어가 주어지면 단어장에 해당 단어를 출력하고
	 * 단어가 있는지 없는지를 알려주는 메서드
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 없음 => void
	 * 메서드명 : search
	 */
	public boolean search(String title) {
		int index = indexOf(title);
		if( index == -1) {
			System.out.println("No words found");
			return false;
		}
		wordList[index].print();
		return true;
	}
	
	
	/**단어와 수정할 뜻의 번호와 수정할 뜻이 주어지면 단어의 뜻을 수정하고
	 * 수정여부를 알려주는 메서드
	 * 매개변수 : 단어, 수정할 뜻 번호, 수정할 뜻
	 * 		=> String title, int meaningIndex, String meaning
	 * 리턴타입 : 없음 => void
	 * 메서드명 : updateMeaing
	 */
	public boolean updateMeaning(String title, int meaningIndex, String meaning) {
		int index = indexOf(title);
		if(index == -1) {
			System.out.println("No words found");
			return false;
		}
		
		if(!wordList[index].updateMeaning(meaningIndex, meaning)) {
			//System.out.println("Wrong number");
			return false;
		}
		return true;
	}
	
	
	/** 단어와 수정할 단어가 주어지면 단어를 수정하고 수정여부를 메서드
	 * 매개변수 : 단어와 수정할 단어, >> String title, String updateTitle
	 * 리턴타입: void
	 * 메서드명: updateTitle
	 */
	public boolean updateTitle(String title, String updateTitle) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("No words found");
			return false;
		}
		
		wordList[index].setTitle(updateTitle);
		return true;
	}
	
}
