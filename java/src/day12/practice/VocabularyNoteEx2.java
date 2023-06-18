package day12.practice;

public class VocabularyNoteEx2 {
	public static void main(String[] args) {
			// �쁺�뼱 �떒�뼱�옣
		Word wordList[]= {
				new Word("abc"),
				new Word("def"," define")
		};
		
		VocabularyNote note = new VocabularyNote(wordList);
		//note.print();
		
		
		Word word = new Word("a", "A");
		note.insert(word);
		//note.print();
		note.insert("b", "b is b");
		//note.print();
		
		//note.delete("c"); // No words found 출력
		note.delete("a");
		//note.print();s
		
		//note.search("a");
		//note.search("b");
		
		note.insert("b","b");
		//note.print();

		
		note.updateMeaning("b", 1, "B");
		note.updateMeaning("b", 3, "B");
		//note.print();
		
		note.updateTitle("b", "B");
		note.print();
	}

}