package singleton;

public class CompanyTest {

	public static void main(String[] args) {
		
		// 4단계: 실제 사용 코드 구현
		// 외부클래스에서는 company 를생성할 수 없으므로 static으로 제공되는 getInstance() 메서드를 호출
		// Company.Instance(); 와 같이 호출하면 반환 값으로 유일한 인스턴스를 받아옴.
		Company myCompany1 = Company.getInstance();
		Company myCompany2 = Company.getInstance();
		System.out.println(myCompany1 == myCompany2);
	}

}
