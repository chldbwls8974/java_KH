package array;

public class Array {
	
	// print Array
	public static void printArray(int arr[]) {
		int i;
		for (i =0; i <arr.length ; i++) {
			System.out.print(arr[i] + (i==arr.length-1?"\n":","));
		}
	}
	
	// Array print from start to end-1
	public static void printArray(int arr[], int start, int end) {
		System.out.print("[");
		for(int i = start; i < end;i++) {
			if(i >= arr.length) {
				break;
			}
			System.out.print(arr[i] + (i==end-1?"":","));
		}
		System.out.println("]");
	}
	
	
	
	// Prevent Duplication
	// num가 배열의 원소 중에서 0번지 부터 count개 안에 있는지 확인하는 메서드
	public static boolean contains(int arr[], int num, int count) {
		for(int i = 0 ; i < count ; i++) {
			if(num == arr[i]) {
				return true;
			}
		}
		return false;

	}
	
	public static void creatRandomArray(int min, int max, int arr[]) {
		
		if(arr == null) return;

		if(max - min + 1 < arr.length) return;
		
		int count = 0; 
		while(count < 3) {
			
			int ran = (int)( Math.random()*(max - min + 1) +min);
			if(!contains(arr,ran,count)) {
				arr[count] = ran;
				count++;
			}
		}
	}
	
	
	public static int[] creatRandomArray2(int min, int max, int arr[]) {
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		if(arr == null) {
			arr = new int[max-min+1];
		}
		
		if(max - min + 1 < arr.length) return null;
		
		
		int count = 0; 
		while(count < arr.length) {
			
			int ran = (int)( Math.random()*(max - min + 1) +min);
			if(!contains(arr,ran,count)) {
				arr[count] = ran;
				count++;
			}
		}
		return arr;
	}
	
	
	// 주어진 배열에 중복된 값이 있는지 없는지 
	public static boolean arrayCheck(int arr[]) {
		if (arr == null) {
			return false;
		}
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr.length ; j++) {
				if(i == j) continue; // 같은 번지면 뛰어넘음
				if(arr[i]==arr[j]) return true; // 다른번지이고 값이 같으면 중복이라고 리턴.
			}
		}
		return false; // 중복이 안된것임.
	}
}
