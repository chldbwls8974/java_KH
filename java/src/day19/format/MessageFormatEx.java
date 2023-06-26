package day19.format;

import java.text.MessageFormat;

public class MessageFormatEx {

	public static void main(String[] args) {

		int x = 1, y = 2;
		
		String message = "({0},{1})";
		String str2 = MessageFormat.format(message, x,y);
		System.out.println(str2);
		
		x = 10;
		y = 20;
		str2 = MessageFormat.format(message, x,y);
		System.out.println(str2);
		
	}

}
