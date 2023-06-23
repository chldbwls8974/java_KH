package day18.homework;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ImgEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0; 
		
		String st[] = new String[3];
		
		st[0] = "^[a-zA-Z\\.]+(jpg)$";
		st[1] = "^[a-zA-Z\\.]+(bmp)$";
		st[2] = "^[a-zA-Z\\.]+(png)$";
		
		
		System.out.print("input : ");
		String str = sc.nextLine();
		
		for(int i = 0 ; i < st.length ; i++) {
			if(Pattern.matches(st[i], str)== true) {
				count++;
			}
		}
		
		if(count!=0) {
			System.out.println(str + " : Image");
		}
		else System.out.println(str + "Not Image");
		
		sc.close();
	}

}
