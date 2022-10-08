import java.util.InputMismatchException;
import java.util.Scanner;

public class p5 {

	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int [] inputArr = new int[10];
		
		System.out.print("양의 정수 10개를 입력하세요 >> ");
		
		try {
			for (int i = 0; i<inputArr.length; i++) {
				inputArr[i] = scanner.nextInt();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("정수만 입력하세요!");
		}
		
		boolean isExist = false;
		
		System.out.print("3의 배수는 ");
		for (int i = 0; i<inputArr.length; i++) {
			if (inputArr[i]%3==0) System.out.print(inputArr[i] + " ");
			isExist = true;
		}
		
		if (!isExist) System.out.println("없습니다.");
	}
}
