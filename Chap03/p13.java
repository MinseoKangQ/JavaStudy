public class p13 {
	
	public static void main(String [] args) {
		
		// 한 자리 숫자인 경우
		for (int i = 1; i<=9; i++) {
			if (i % 3 == 0 )
				System.out.println(i + " 박수 짝");
		}
		
		
		// 두 자리 숫자인 경우 
		for (int i = 10; i<=99; i++) {
			
			int isInclude369 = 0;
			int tenDigit = i/10;
			int oneDigit = i%10;
			
			// 십의 자리에 3 혹은 6 혹은 9가 포함되어 있는 경우 
			if(tenDigit == 3 || tenDigit == 6 || tenDigit == 9)
				isInclude369++;
			// 일의 자리에 3 혹은 6 혹은 9가 포함되어 있는 경우
			if(oneDigit == 3 || oneDigit == 6 || oneDigit == 9)
				isInclude369++;
			
			// 3이나 6이나 9가 포함된 갯수에 따라 출력하는 것 다름 
			if (isInclude369 == 1)
				System.out.println(i + " 박수 짝");
			else if (isInclude369 == 2)
				System.out.println(i + " 박수 짝짝");
			
		}
	}
}
