package day18.string;

public class StringEx1 {

	public static void main(String[] args) {

		/* 문자열 관련 메서드 */
		
		// indexOf : 기준 문자열에서 검색 문자 / 문자열을 왼쪽에서부터 검색해서처음으로 만나는 위치를 반환
		// lastIndexOf : 오른쪽에서부터 검색함.
		String str = "Hello World";
		
		// str에서 7번지부터 Wo가 있는지 확인. orld에서 wo가 있는지 확인 >> 없음 >> -1
		int index = str.indexOf("l",3); // , 숫자 >> 탐색 위치 지정
		System.out.println(str + "에서 7번지부터 Wo 가 있나요? " + index);
		
		index = str.indexOf("Wo");
		System.out.println(index);
		
		// 처음 만나는 4번지만 출력됨
		index = str.indexOf("o");
		System.out.println(index);
		
		// contains : 기존 문자열에서 검색 문자 / 문자열이 있는지 업슨지를 알려줌
		boolean result = str.contains("o");
		System.out.println(result);
		
		System.out.println(str + "의 길이는?" + str.length());
		
		// replace : 특정 문자열을 을 바꿀 때 사용, 모두
		// replaceAll : 정규표현식에 맞느 모든 문자/문자열을 수정
		String str2 = str.replace(" ", ",");
		System.out.println(str2);
		
		//  substring : 부분 문자열 추출
		// 
		String str3 = str.substring(6);
		System.out.println(str + "에서 6번지부터 부분문자열 " + str3);
		
		// lastIndexOf
		index = str.lastIndexOf("o"); // , 숫자 >> 탐색 위치 지정
		System.out.println(str + "에서 오른쪽부터 몇번지에 o? " + index);
		
		// toLowerCase : 소문자로 변환
		System.out.println(str +" : " + str.toLowerCase());
		// toUpperCase : 대문자로 변환
		System.out.println(str + " : " + str.toUpperCase());
		System.out.println("==========================================");

		
		// trim
		String str4 = "\n\t\tabc\t\tdef\t\n";
		System.out.println(str4);
		System.out.println("==========================================");
		System.out.println(str4.trim());
		System.out.println("------------------------------------------");

		System.out.println("trim()은 문자열 앞뒤의 공백을 모두 제거해준다.");
		System.out.println("==========================================");

		
		// split : 구분자를 기준으로 문자열을 추출 후 순서대로 배열에 저장
		String str5 = "사과,배,포도";
		String fruits[] = str5.split(",");
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
	}

}
