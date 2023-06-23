package day18.practice;

import java.util.Scanner;

public class StringCharAtEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int alphabet[]=new int[26]; // 각 알파벳 개수를 저장하는 배열 , 0번지에는 a의 개수, 1번지에는 b의 개수
		
		System.out.print("input String : ");
		String str = sc.nextLine();
		
		
		for(int i = 0; i < str.length() ; i++) {
			char ch = str.charAt(i);
			// ch가 알파벳 소문자인 경우 0~25 
			
			int dis = ch - 'a';
			
			if(dis < 0 || dis > 25) {
				continue;
			}
			
			alphabet[dis]++;
		}
		
		//알파벳 개수 추가
		for(int i = 0 ; i < alphabet.length ; i++) {
			if(alphabet[i]==0) {
				continue;
			}
			System.out.println((char)('a'+i) + " : " + alphabet[i]);
			
		}
		
		
		
		sc.close();
	}

}
