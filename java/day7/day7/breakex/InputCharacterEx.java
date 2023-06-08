package day7.breakex;
import java.util.*;
public class InputCharacterEx {

	public static void main(String[] args) {

		// q를 입력하면 반복문 종료
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.println("Input charater (exit : q) ");
			char ch = sc.next().charAt(0);
			
			if(ch == 'q')
				break;
		}
		
		sc.close();
	}

}
