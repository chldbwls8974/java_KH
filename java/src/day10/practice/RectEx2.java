package day10.practice;

import java.util.Scanner;

public class RectEx2 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	int a;
	char ans;
	
	System.out.println("input start edge x,y and width and height");
	int x = sc.nextInt();
	int y = sc.nextInt();
	int w = sc.nextInt();
	int h = sc.nextInt();
	
	Rect rt1 = new Rect(x,y,w,h);
	rt1.print();
	
	do {
	
	System.out.println("Do you want to move or change?");
	System.out.println("If you want to move, press m");
	System.out.println("Or if you want to chage, press c");
	ans = sc.next().charAt(0);
	
	switch(ans) {
	case 'm':
		System.out.println("===================");
		System.out.println("Enter the px to move");
		x = sc.nextInt();
		y = sc.nextInt();
		rt1.move(x, y);
		rt1.print();
		break;
		
	case 'c':
		System.out.println("===================");
		System.out.println("Enter the width and height to change");
		w = sc.nextInt();
		h = sc.nextInt();
		rt1.change(w, h);
		rt1.print();
		break;

			
	}
	System.out.println("Press 0 to continue");
	 a = sc.nextInt();
	}while(a==0);
	
	
	sc.close();
	}
}