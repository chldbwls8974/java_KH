package constructor;

public class PersonTest {

	public static void main(String[] args) {
		
		//디폴트 생성자로 클래스 생성 후 인스턴스 변수값을 따로 초기화
		Person personKim = new Person();
		personKim.name = "김유신";
		personKim.weight = 85.5F;
		personKim.height = 180.0F;
		
		Person personLee = new Person("이순신", 175, 75); //인스턴스 변수 초기화와 동시에 클래스 생성
	}

}
