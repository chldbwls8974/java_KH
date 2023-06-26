package day19.format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {

		int price = 10000; //10,000으로 출력
		
		// #은 빈자리가 있을 때 0 으로 안채움
		DecimalFormat df = new DecimalFormat("###,###");  // 정수 3자리마다 , 를 추가
		String str1 = df.format(price);
		System.out.println(str1);
		
		
		// 0은 빈자리가 있을 때 0으로 채움
		df = new DecimalFormat("000,000"); 
		String str2 = df.format(price);
		System.out.println(str2);
	}

}
