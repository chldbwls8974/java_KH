package day21.set;

import java.util.ArrayList;
import java.util.HashSet;

public class SetRandomEx {

	public static void main(String[] args) {
		// 중복되지 않은
		/*배열을 이용해서 1~9 사이 랜덤한 수 3개 저장*/
		int arr[] = new int[3];
		int count = 0;
		int min = 1, max = 9;
		while(count < 3) {
			int r = random(min, max);
			int i;
			for(i = 0 ; i < count ; i++) {
				if(arr[i]==r) {
					break;
				}
			}
			if(i == count) {
				arr[count++] = r;
			}
		}
		System.out.print("array: [" );
		for(int i = 0 ; i <arr.length ; i++) {
			System.out.print( arr[i] + (i == arr.length -1 ? "":", "));
		}
		System.out.println("]");

		System.out.println("===================");
		
		
		
		/*list을 이용해서 1~9 사이 랜덤한 수 3개 저장*/
		ArrayList<Integer> list = new ArrayList<>();
		while(list.size() < 3) {
			int r = random(min, max);
			if(!list.contains(r)) {
				list.add(r);
			}
		}
		
		System.out.println("list: " + list);
		
		System.out.println("===================");
		
		
		/*set을 이용해서 1~9 사이 랜덤한 수 3개 저장*/
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 3) {
			int r = random(min, max);
			set.add(r);
		}
		System.out.println("set: " + set); // set은 정렬이 안되는것이 맞는데, 값이 작은 수 이면 정렬이 되는 현상이 있음.
		
		

	}
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()* (max - min + 1) + min);
	}
}
