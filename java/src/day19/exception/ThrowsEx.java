package day19.exception;

public class ThrowsEx {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		int res;
		int arr[] = {1,3,5};
		
		//res = mod1(num1, num2);
		try {
			arr = null;
			printArray(arr);
			res = mod2(num1, num2);
			System.out.println(res);
		} catch (Exception e) {
			//System.out.println("Exception : / by zero");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 예외 경로 출력.. 프로그램이 중단된것이 아님.
		}
		System.out.println("EXIT");
		
		
	}

	// try catch를 이용하여 예외 직접 처리
	public static int mod1(int num1, int num2) {
		try {
		int res =  num1 % num2;
		return res;
		}catch(Exception e) {
			System.out.println("Exception : / by zero");
			return 0;
		}
	}
	
	
	// throws 를 이용하여 예외 처리를 미룸
	public static int mod2(int num1, int num2) throws Exception {
		return num1 % num2;
	}
	
	
	public static void printArray(int arr[]) throws Exception {
		if(arr == null) {
			throw new Exception("Array is null"); // 없던 예외가 생긴것 >> throw 처리해야함
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
}
