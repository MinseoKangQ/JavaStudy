public class p7 {

	public static void main(String [] args) {
		
		int randomInt [] = new int [10];
		int sum = 0;
		
		System.out.print("랜덤한 정수들 : " );
		for (int i = 0; i<randomInt.length; i++) {
			randomInt[i] = (int)(Math.random()*10+1);
			System.out.print(randomInt[i] + " ");
			sum += randomInt[i];
		}
		System.out.println();
		
		double average = sum/(double)(randomInt.length);
		
		System.out.println("평균은 " + average);
		
	}
}
