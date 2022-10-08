import java.util.Scanner;

public class p6 {

	public static void main (String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // 환산할 돈의 종류
		
		int res, money;
		System.out.print("금액을 입력하시오 >> ");
		money = scanner.nextInt();
		
		for (int i = 0; i<unit.length; i++) {
			res = money/unit[i];
			money = money % unit[i];
			if(res>0) System.out.println(unit[i] + "원 짜리 : " + res + "개");
		}
		
		
	}
}
 