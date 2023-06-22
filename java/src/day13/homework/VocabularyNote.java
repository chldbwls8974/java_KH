package day13.homework;

import day12.practice.Word;

public class VocabularyNote{

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
	

	
	/** �ܾ �־����� �ܾ��忡 �߰��ϴ� �޼���( �ܾ� ��ü�� �Ѱ��ִ� ���)
	 * �Ű�����:  �ܾ� (�ܾ� ��ü) >> Word word
	 * ����Ÿ��: ����
	 * �޼���� : insert
	 */
	public void insert (Word word) {
		//�ܾ��忡 �ܾ �� á�� ��츦 ���� ���� 
		if(wordCount==wordList.length) {
			System.out.println("Vocabulary note is full!");
			return;
		}
		// ���� ���縦 ���� Word�� ���� �����ڸ� �̿��Ͽ� �� �ܾ ������ �� �߰�
		wordList[wordCount++] = new Word(word);
		
	}
	
	
	/** �ܾ�� ���� �־����� �ܾ��忡 �߰��ϴ� �޼���( �ܾ�� ���� �Ѱ��ִ� ���)
	 * ���� �ܾ��̸� ���� �ܾ �߰��ϰ�,
	 * �ִ� �ܾ��̸� �游 ���� �߰��ϴ� �޼���
	 * �Ű�����: �ܾ�� ��>>Stirng title, String meaning  
	 * ����Ÿ�� > ����
	 * �޼����: insert
	 */
	public void insert (String title, String meaning) {
		//�ܾ��忡 �ܾ �� á�� ��츦 ���� ���� 
		if(wordCount==wordList.length) {
			System.out.println("Vocabulary note is full!");
			return;
		}
		
		int index = indexOf(title);
		// ���� �ܾ��̸� �� �ܾ�� �߰�
		if(index == -1) {
			// �ܾ�� ���� �̿��� �ܾ� ��ü�� ������ �� �ܾ��忡 �߰�
			wordList[wordCount++] = new Word(title, meaning);
			return;
		}
		// �ִ� �ܾ��� ��� �� �߰�
		wordList[index].addMeaning(meaning);
	}
	
	
	
	/** �ܾ �־����� �پ��忡�� �����ϴ� �޼���
	 * �Ű����� : ������ �ܾ�  String title
	 * ����Ÿ�� : ���� // 
	 * �޼����: delete
	 */
	
	public void delete(String title) {
		// �ܾ ����ִ��� ã�ƾ���
		int index = indexOf(title);
		//�ܾ �ܾ��忡 ������ �˸� �޼��� ��� �� ����
		if( index == -1) {
			System.out.println("No words found");
			return;
		}
		
		// ã�� ��ġ���� ��ĭ�� ��ܿ�.
		for(int i = index ; i < wordCount -1 ; i++) {
			wordList[i] = wordList[i+1];
			
		}
		// e�ܾ��� ������ �ϳ� �ٿ�����.
		wordCount--;
		
		// ������ �ܾ �����(null)
		wordList[wordCount]= null;
	}
	
	
	
	/** �ܾ �־����� �ܾ �ִ� ��ġ�� �˷��ִ� �޼���
	 * �ܾ ������ ���������� -1�� ����
	 * �Ű�����: �ܾ� > String title
	 * ����Ÿ��: ��ġ > ����  int
	 * �޼����: indexOf
	 */
	public int indexOf(String title) {
		//�ܾ��忡 ��ϵ� �ܾ���� ��ȸ
		for(int i= 0; i < wordCount ; i++) {
			// �ܾ ������ i������ ����
			if(wordList[i].getTitle().equals(title)) {
				return i;
			}
		}
		// ������� ���� ��ġ�ϴ� �ܾ ����
		return -1;
	}
	
	
	
	/**�ܾ �־����� �ܾ��忡 �ش� �ܾ ����ϴ� �޼���
	 * �Ű����� : �ܾ� => String title
	 * ����Ÿ�� : ���� => void
	 * �޼���� : search
	 */
	public void search(String title) {
		int index = indexOf(title);
		if( index == -1) {
			System.out.println("No words found");
			return;
		}
		wordList[index].print();
	}
	
	
	/**�ܾ�� ������ ���� ��ȣ�� ������ ���� �־����� �ܾ��� ���� �����ϴ� �޼���
	 * �Ű����� : �ܾ�, ������ �� ��ȣ, ������ ��
	 * 		=> String title, int meaningIndex, String meaning
	 * ����Ÿ�� : ���� => void
	 * �޼���� : updateMeaing
	 */
	public void updateMeaning(String title, int meaningIndex, String meaning) {
		int index = indexOf(title);
		if(index == -1) {
			System.out.println("No words found");
			return;
		}
		
		if(!wordList[index].updateMeaning(meaningIndex, meaning)) {
			System.out.println("Wrong number");
		}
	}
	
	
	/** �ܾ�� ������ �ܾ �־����� �ܾ �����ϴ� �޼���
	 * �Ű����� : �ܾ�� ������ �ܾ�, >> String title, String updateTitle
	 * ����Ÿ��: void
	 * �޼����: updateTitle
	 */
	public void updateTitle(String title, String updateTitle) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("No words found");
			return;
		}
		
		wordList[index].setTitle(updateTitle);
	}
	
}
