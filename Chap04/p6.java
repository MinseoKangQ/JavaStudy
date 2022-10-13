import java.util.Scanner;

class Circle2 {
	
	// 필드
	private double x, y;
	private int radius;
	
	// 생성자 메소드 
	public Circle2(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	// Circle의 정보를 출력하는 메소드
	public void show() {
		System.out.println("(" + x + "," + y + ")" + radius);
	}
	
	public int getRadius() { return radius; }
	
}

public class p6 {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Circle2 c [] = new Circle2[3]; // 3개의 Circle 배열 선언
		
		for(int i = 0; i<c.length; i++) {
			System.out.print("x, y, radius >> ");
			double x = scanner.nextDouble(); // x 값 읽기 
			double y = scanner.nextDouble(); // y 값 읽기 
			int radius = scanner.nextInt(); // radius 값 읽기
			c[i] = new Circle2(x, y, radius);
		}
		
		// 면적이 가장 큰 것 판단하기
		int biggestIndex = 0;
		for (int index = 1; index<c.length; index++) {
			if (c[biggestIndex].getRadius() < c[index].getRadius())
				biggestIndex = index;
		}
		
		System.out.print("가장 면적이 큰 원은 ");
		c[biggestIndex].show();
		
		
		scanner.close();
		
	}
}
