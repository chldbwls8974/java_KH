package day21.practice;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(10);
		list.add(3);
		list.add(2);
		
		System.out.println(list);
		
		/* 리스트에 있는 sort는 compare메서드를 가진 객체가 필요
		 * 왜? >> 정렬 기준을 compare로 하기 때문
		 * compare 값이 음수이면 앞으로 , 같으면 0, 양수이면 뒤로
		 * 객체가 compare 메서드를 반드시 갖게하기 위해 comparator 인터페스를 구현한
		 * 구현 클래스의 객체만 올 수 있게 지정
		 * */
		//list.sort(new IntegerCompare());
		//System.out.println(list); 
		
		
		
		//list.sort(new IntegerCompare());
		// Comparator 인터페이스의 익명 ㅡㄹ래스를 만들어서 객체 생성
		
		list.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}});
		System.out.println(list);
		
		
		// 람다식 이용
		list.sort((Integer o1, Integer o2)-> o2-o1);
		System.out.println(list);
	}

}


class IntegerCompare implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}