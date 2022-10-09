import java.util.Scanner;

public class p8 {

	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 몇개? ");
		int numOfInt = scanner.nextInt();
		
		int intArray [] = new int [numOfInt];
		
		for(int i = 0; i<intArray.length; i++) {
			
			intArray[i] = (int)(Math.random()*100+1);
			for(int k=0; k<i; k++) {
				if(intArray[i] == intArray[k])
					i--;
			}
			
		}
		for(int i=0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
			if ( (i+1) % 10 == 0) System.out.println();
		}
	}
}
