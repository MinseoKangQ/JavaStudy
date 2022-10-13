import java.util.Scanner;

class Circle {
	
	// 필드
	private double x, y;
	private int radius;
	
	// 생성자 메소드 
	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	// Circle의 정보를 출력하는 메소드
	public void show() {
		System.out.println("(" + x + "," + y + ")" + radius);
	}
	
}

public class p5 {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Circle c [] = new Circle[3]; // 3개의 Circle 배열 선언
		
		for(int i = 0; i<c.length; i++) {
			System.out.print("x, y, radius >> ");
			double x = scanner.nextDouble(); // x 값 읽기 
			double y = scanner.nextDouble(); // y 값 읽기 
			int radius = scanner.nextInt(); // radius 값 읽기
			c[i] = new Circle(x, y, radius);
		}
		
		for(int i = 0; i<c.length; i++) c[i].show(); // 모든 Circle 객체 출력 
		scanner.close();
		
	}
}
