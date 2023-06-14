package day11.array;

public class ArrayMethodEx1 {

	public static void main(String[] args) {
		// 메서드의 매개변수와 관련된 예제
		int num1 = 10, num2 = 20;
		/*
		// 두 정수를 교환
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
		*/
		
		swap(num1, num2);  // 바뀌지않음
	
		int arr1[] = {1,2,3,4};
		int arr2[] = {5,6,7,8};
		int tmpArr[] = new int [arr1.length];
		
		printArr(arr1);
		printArr(arr2);
		
		
		System.out.println("======= ");
		
		// 두 배열을 교환
		// 매개변수로 넘겨준 배열의 주소가 메서드 안에서 바뀌면 워논에 영향이 없음
		swap(arr1, arr2);
		
		// 매개변수로 넘겨준 배열의 주소가 아닌 배열의 값이 메서드 안에서 바뀌면
		// 원본이 영향을 받음
		swap2(arr1, arr2);
		
		printArr(arr1);
		printArr(arr2);
		
	}

	public static void printArr(int arr[]) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}
	
	/** 두 배열을 교환하는 메서드 1 : 교환이 안됨 */
	public static void swap(int arr1[], int arr2[]) {
		int tmpArr[] = arr1;
		arr1 = arr2;
		arr2 = tmpArr;
		
	}
	
	/** 두 배열을 교환하는 메서드 2 : 교환 가능*/
	public static void swap2(int arr1[], int arr2[]) {
		int tmp[] = new int [arr1.length];
		for (int i = 0; i < arr1.length ; i++) {
			tmp[i] = arr1[i];
			arr1[i] = arr2[i];
			arr2[i] = tmp[i];
		}
	}
	
	/** 두 정수의 값을 교환하는 메서드 : 교환이 안됨 */
	public static void swap(int num1, int num2) {
		// 매개변수 num1과 num2는 메서드가 호출되면 새로 변수를 만들어서
		// 호출한 곳에서 넘겨준 값을 복사해 옴 (복사본으로 메서드 실행
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}
	
}
