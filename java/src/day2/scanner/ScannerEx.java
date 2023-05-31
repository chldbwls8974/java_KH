package day2.scanner;

//import java.util.Scanner;
import java.util.*; // java안에 있는 모든 클래스를 가져온다. (*) 단축키 : ctrl + shift + 5

public class ScannerEx {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in); // System.in : 표준입력, 표준입력을 이용해서 스캐너 생성
			
			System.out.println("정수.");	
			int num = sc.nextInt(); //스페이스를 포함한 문자열 한줄을 읽어옴 (마지막 입력한 엔터포함			
			System.out.println(num);
			
			
			System.out.println("문자열1을 입력하세요.");
			sc.nextLine();	
			String str1 = sc.nextLine(); //스페이스를 포함한 문자열 한줄을 읽어옴 (마지막 입력한 엔터포함			
			System.out.println(str1);
			
			System.out.println("문자열2을 입력하세요.");
			String str2 = sc.next();			// 첫번째 문자부터 읽어와서 다음 공백이 오기전까지 읽어옴
			System.out.println(str2);
			
			System.out.println("문자를 입력하세요.");
			//next()을 이용하여 한 단어를 읽어오고
			// charAt(0)을 이용하여 읽어온 단어의 첫 글자를 가져옴
			char ch = sc.next().charAt(0);
			System.out.println(ch);

			sc.close();
	}

}
