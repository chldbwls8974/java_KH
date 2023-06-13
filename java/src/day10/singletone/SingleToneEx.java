package day10.singletone;

public class SingleToneEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SamsungCompany company1 = SamsungCompany.getInstance();
		SamsungCompany company2 = SamsungCompany.getInstance();
		System.out.println(company1); // 해당 참조변수의 주소가 출력
		System.out.println(company2); // 1과 2가 같은 주소가 출력 됨 == 하나의 객체를 공유하고 있음
		
	}

}

class SamsungCompany{
	

	private static SamsungCompany company = new SamsungCompany();
	
	private String name;
	private String address;
	
	// public인 경우에는 외부에서 new를 사용해서 얼마든지 객체를 만들 수 있지만
	// private 인 경우에는 new를 통해 만들 수 없다.
	// 내부에서 만들어야한다.
	

	private SamsungCompany() {
		name = "Samsung";
		address = "korea";
	}
	
	public static SamsungCompany getInstance() {
		return company;
	}
	
	
}
