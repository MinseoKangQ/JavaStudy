class ArrayUtil {
	
	// main이 static 함수이므로 static 함수로 작성
	// 배열 연결하는 메소드 
	public static int [] concat(int [] a, int [] b) {
		
		int newArrayLength = a.length + b.length; // 새로운 배열 길이
		
		int newArray [] = new int [newArrayLength]; // 새로운 배열 선언
		
		// 배열에 값 삽입
		for (int i = 0; i<newArrayLength; i++) {
			if (i<a.length) newArray[i] = a[i];
			else newArray[i] = b[i-a.length];
		}
		
		// 배열 리턴
		return newArray;
		
	}
	
	// 배열 프린트하는 메소드
	public static void print(int [] arr) {
		
		System.out.print("[ ");
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println(" ]");
	}
	
}

public class StaticEx {
	
	public static void main(String [] args) {
		
		int [] arr1 = { 1, 5, 7, 9 };
		int [] arr2 = { 3, 6, -1, 100, 77 };
		int [] arr3 = ArrayUtil.concat(arr1, arr2);
		ArrayUtil.print(arr3);
		
	}
	
}
