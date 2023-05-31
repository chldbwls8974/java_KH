package chapter5;

public class PersonTest {

	public static void main(String[] args) {
		Person man = new Person();
		man.age = 40;
		man.name = "James";
		man.isMarried = true;
		man.child = 3;
		
		System.out.println("이 사람의 나이 :" + man.age);
		System.out.println("이 사람의 이름 : " + man.name);
		System.out.println("이 사람의 결혼여부 : " + man.isMarried);
		System.out.println("이 사람의 자녀 수 : " + man.child);
		
	}

}
