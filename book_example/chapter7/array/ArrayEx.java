package array;

public class ArrayEx {

	public static void main(String[] args) {
		
		int[] num = new int[] {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		
		for(int i = 0; i<10 ; i++) {
			System.out.print("" + sum + " + " + num[i]);
			sum += num[i];
			System.out.println(" = " + sum);
		}
		
		System.out.println(sum);
	}

}
