package day22.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LambdaStudentEx {

	public static void main(String[] args) {
		/* 학생 정보를 출력하는 기능을 구현하세요.
		 * 1. 학생 전체 출력
		 * 2. 학생 학년 출력
		 * 3. 학생 검색 출력
		 * 4. 종료
		 * 
		 */

		List<Student> list = Arrays.asList(
				new Student(1,1,1,"Hong"),
				new Student(1,1,2,"Ling"),
				new Student(2,1,1,"Park"),
				new Student(3,1,1,"Lee"),
				new Student(3,3,2,"Kim")
				);
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 학생 전체출력");
		System.out.println("2. 학생 학년출력");
		System.out.println("3. 학생 검색출력");
		System.out.println("4. 종료");
		
		System.out.println("===========");
		System.out.print("메뉴를 입력하세요: ");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1: 
			printStudent(list);
			break;
		case 2: 
			Function<Student, Integer> function = std -> ((Student) list).getClassNum();
			//printStudent(function, std -> ((Student) list).getClassNum() );
			break;
		case 3: break;
		case 4: break;
		default:
		}
		
		
		sc.close();
		
		
		
	
	
	}


	private static void printStudent(Function<Student, Integer> function, List<Student> list) {
		function.apply((Student) list);
		
	}


	public static void printStudent(List<Student> list) {
		System.out.println(list);
	}
	


}

@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
}