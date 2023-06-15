package day12.practice;

public class VocabularyNoteEx2 {
	public static void main(String[] args) {
			// 영어 단어장
		Word wordList[]= {
				new Word("abc"),
				new Word("def"," define")
		};
		
		VocabularyNote note = new VocabularyNote(wordList);
		note.print();
	}

}