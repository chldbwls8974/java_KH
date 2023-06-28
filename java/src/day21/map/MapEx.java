package day21.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx {

	public static void main(String[] args) {

		/* Map을 배열처럼 사용하는 예제*/
		HashMap<Integer, Integer> map = new HashMap<>();
		//배열 0번지에 1, 1번지에 2, ..
		for(int i = 0 ; i < 5 ; i++) {
			map.put(i, i+1);
		}
		// System.out.println(map);
		
		/*아이디, 비번을 관리하는 예제*/
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("abc123", "1234567");
		map2.put("qwer1", "qwer123123");
		//map2.put("abc123", "fdsa4321"); // key가 중복된 정보를 추가 >> 
		map2.put("asdf1", "1234567");
		System.out.println(map2);
		
		
		/*keySet을 이용한 반복문. key값들을 set으로 만들어서 반복*/
		Set<String>  keySet = map2.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String id = it.next(); // key 값을 가져옴
			String pw = map2.get(id); // key 값(id)를 이용해서 value값을 가져옴
			System.out.println(id + " " + pw);
		}
		
		/* Entry 이용하여 
		 * map에 있는 키-값을 entry 객체 하나에 넣어 set으로 만듬*/
		// entry :: 내부 인터페이스 >> 외부에서 직접적으로 사용할 일이 없는 경우 사용 >> map에서만 사용
		// 키-값쌍 을 멤버로 가지는..
		Set<Entry<String, String>> entrySet = map2.entrySet();  
		Iterator<Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Entry<String, String> tmp = it2.next();
			String id = tmp.getKey();
			String pw = tmp.getValue();
			System.out.println(id + " " + pw);
		}
		
	}

}
