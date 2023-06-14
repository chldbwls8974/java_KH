package day11.practice;

public class ArrayRandEx2Solv2 {

	public static void main(String[] args) {
		
		int [] arr = new int[5];
		int max = 9, min = 1;
		
		boolean checkArr[] = new boolean[10];
		
		
		
		// solv 1
		// 작업이 단순. 
		// 단점 : 저장공간이 필요
		
		for(int i = 0 ; i < 5 ; ){
			int ran = (int)( Math.random()*(max - min + 1) +min);
			// checkArr 배열에 ran 번지에 있는 값이 false이면
			// ran을 배열에 저장하고 , i를 증가시키고
			// checkArr 배열에 ran 번지에 있는 값ㅇ르 true로 변경
			
			if(!checkArr[ran]){
				arr[i]=ran;
				i++;
				checkArr[ran]= true;
			}
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("====== solv2 =========");
		
		
		
		// solv2
		// 저장된 값들을 비교
		
		int count = 0; // 현재 저장된 랜덤 개수
		int i = 0; // 반복문에서 사용할 변수
		
		while(count < 5) {
			
			int ran = (int)( Math.random()*(max - min + 1) +min);

			for(i = 0 ; i < count ; i++) {
				if(ran == arr[i]) {
					break;
				}
			}
			// 위 반복문에서 break를 만나지 않으면 i는 count 일때 종료하기 때문에
			// 반복문 종료 후 i는 count와 값다
			// 하지만 break를 만나서 중간에 빠져 나오면 i는 count보다 작다
			if(i == count)
				arr[count] = ran;
				count++;
		}
		// print2 method
		printArray(arr);
		
		
		
		
		
		// solv3 // 방법 2를 메서드로 변형
		// 저장된 값들을 비교
		
		count = 0; // 현재 저장된 랜덤 개수
		while(count < 5) {
			
			int ran = (int)( Math.random()*(max - min + 1) +min);
			// 중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr,ran,count)) {
				arr[count] = ran;
				count++;
			}
		}
		
		System.out.println(" ========== Used Contain Method ========== ");
		printArray(arr);

		
		
		// solv4 // 방법 3의 랜덤생성까지 메서드
		// 저장된 값들을 비교
		
		randomArray(min, max, arr);
		System.out.println(" ========== Used random Method ========== ");
		printArray(arr);
		
		
	}
	
	/** 정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드
	 * 매개변수: 배열과 배열의 개수가 필요
	 * 리턴타입: 
	 * 메서드명: print
	 * 
	 */
	public static void printArray(int arr[], int k ) {
		for(int i = 0 ; i < k ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	/** 정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드
	 * 매개변수: 배열의 길이 length를 이용하여 배열만 있으면 됨.
	 * 리턴타입: 
	 * 메서드명: print
	 * 
	 */
	public static void printArray(int arr[]) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	/** 정수 num가 배열의 0번지부터 count개만큼 확인했을 때 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수:
	 * 리턴타입:
	 * 메서드명: contains
	 */
	public static boolean contains(int arr[], int num, int count) {
		for(int i = 0 ; i < count ; i++) {
			// 중복되면 메서드를 종료하면서 중복됐다고 알려줌.
			if(num == arr[i]) {
				return true;
			}
		}
		// 이 위치까지 왔다는 것은 return true를 만나지 못햇다는 것이고,
		// 중복되지 않았다는 뜻.
		return false;

	}
	
	
	
	
	/** min 에서 max 사이의 랜덤한 수를 생성해서 배열에 저장하는 메서드
	 * 매개변수:
	 * 리턴타입:
	 * 메서드명: randomArray
	 * 
	 */
	public static void randomArray(int min, int max, int arr[]) {
		// 배열이 null이면 
		if(arr == null) return;
		
		// 랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면
		// 1 ~ 3 : 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음
		if(max - min + 1 < arr.length) return;
		
		
		int count = 0; // 현재 저장된 랜덤 개수
		while(count < 5) {
			
			int ran = (int)( Math.random()*(max - min + 1) +min);
			// 중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr,ran,count)) {
				arr[count] = ran;
				count++;
			}
		}
	}

}


















