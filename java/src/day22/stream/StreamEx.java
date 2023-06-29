package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {

		Integer arr[] = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> arrStream = Arrays.stream(arr);
		Stream<Integer> listStream = list.stream();
		
		// 전체출력
		arrStream.forEach(num->System.out.println(num));
		System.out.println("====");
		listStream.forEach(num -> System.out.println(num));
		
		arrStream = Arrays.stream(arr); // stream 은 한번 사용하면 끝이기 때문에 다시 생성
		listStream = list.stream();
		
		// 3보다 큰 수 출력
		System.out.println("====");
		arrStream.filter(num -> num > 3).forEach(num -> System.out.println(num));
		listStream.filter(num -> num > 3).forEach(num -> System.out.println(num));
	}

}
