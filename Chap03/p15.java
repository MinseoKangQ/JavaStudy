import java.util.InputMismatchException;
import java.util.Scanner;

public class p15 {

	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) { // 무한반복 
			try {
				System.out.print("곱하고자 하는 두 수 입력 >> ");
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				System.out.print(n + "x" + m + "=" + n*m); 
				break; // 정상적으로 출력 되었다면 무한루프 빠져나옴
			}
			catch (InputMismatchException e){ // 정수가 아닌 다른 타입이 입력된다면
				scanner.nextLine();
				System.out.println("실수는 입력하면 안됩니다.");
			}
		}
	}
}
