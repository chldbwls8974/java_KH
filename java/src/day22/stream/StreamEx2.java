package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx2 {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(
				new Student(1,1,1,"Hong",100,90,80),
				new Student(1,1,2,"Ling",76,89,66),
				new Student(2,1,1,"Park",74,99,87),
				new Student(3,1,1,"Lee",39,57,77),
				new Student(3,3,2,"Kim",67,35,86)
				);
		
		// 국어 성적이 60점 이상인 학생들의 이름을 출력
		Stream<Student> stream = list.stream();
		stream
		.filter(s -> s.getKor() >= 60) // 걸러주고
		.map(s -> s.getName()) // 타입 변형
		.forEach(name -> System.out.println(name)); // 하나씩 꺼내주는 것
		
		
		// 국어 성적의 총합 출력 ver1 :: mapToInt
		stream = list.stream();
		int sum = stream.mapToInt(std -> std.getKor()).sum();
		System.out.println(sum);
		
		
		// ver2 :: map 과 reduce 사용
		stream = list.stream();
		sum = stream.map(std -> std.getKor()).reduce(0,(a,b)->a+b);
		System.out.println(sum);
		
		
		// 국어 성적의 평균 출력
		stream = list.stream();
		double avg = stream
				.mapToInt(std -> std.getKor())
				.average()
				.getAsDouble();
		System.out.println(avg);
		
		
		
	}

}


@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
	int kor, math, eng;
}
