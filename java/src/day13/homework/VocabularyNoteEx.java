package day13.homework;

import java.util.Scanner;

import day12.practice.VocabularyNote;
import day12.practice.Word;

public class VocabularyNoteEx {
	public static void main(String[] args) {
		Word wordList[]= {};
		
		VocabularyNote note = new VocabularyNote(wordList);
		
		
		Scanner sc = new Scanner(System.in);
		String menu;
		int submenu, num;
		String title;
		String meaning;
		String newTitle;
		
		do {
			System.out.println("input menu");
			System.out.println("add, delete, modify, ");
			menu = sc.next();
		switch(menu) {
		case "add":
			System.out.println("Enter the words you want to add.");
			title=sc.next();
			note.insert(new Word(title));
			note.print();
			break;
		case "delete":
			System.out.println("Enter the word you want to delete.");
			title=sc.next();
			note.delete(title);
			note.print();
			break;
		case "modify":
			System.out.println("input number of sub menu");
			System.out.println("1. word modification	 2. meaning modification	  3. meaning delete ");
			submenu = sc.nextInt();
			
			switch(submenu) {
				case 1:
					System.out.println("Enter the word ");
					title = sc.next();
					System.out.println("Enter the word you want to modify");
					newTitle = sc.next();
					note.updateTitle(title, newTitle);
					note.print();
					break;
				case 2:
					System.out.println("Enter the word");
					title = sc.next();
					System.out.println("Enter the number of meaning you want to modify ");
					num = sc.nextInt();					
					System.out.println("Enter the  meaning you want to modify ");
					meaning = sc.next();		
					note.updateMeaning(title, num, meaning);
					note.print();
					break;
				}
			}
		
			
			
		}while(!menu.equals("exit"));
		System.out.println("good");
		
		sc.close();
		
		
	}

}
