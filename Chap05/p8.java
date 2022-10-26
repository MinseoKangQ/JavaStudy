class Point4 {
	
	// 필드
	private int x,y; // x,y 좌표
	
	// 생성자 메소드 
	public Point4(int x, int y) { this.x = x; this.y = y; }
	
	// getter 메소드 
	public int getX() { return x; }
	public int getY() { return y; }
	
	// 좌표 이동시키는 메소드 
	protected void move(int x, int y) { this.x = x; this.y = y; }
	
}

class PositivePoint extends Point4 { // Point4를 상속받는 PositivePoint
	
	// 생생자 메소드 (매개변수 없음)
		public PositivePoint() {
			super(0, 0);
		}
		
	// 생생자 메소드 (매개변수 있음)
	public PositivePoint(int x, int y) {
		super(x, y);
	}
	
	// 좌표 이동 메소드
	public void move(int x, int y) {
		if (x>=0 && y>=0)	super.move(x,y);
	}
	
	
	
	// 좌표를 String으로 리턴하는 메소드 
	public String toString() { return ("(" + getX() + ", " + getY() +")의 점");}
	
}

public class p8 {

	public static void main(String [] args) {
		
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString() + "입니다.");
		
		p.move(-5, -5);
		System.out.println(p.toString() + "입니다.");
		
		PositivePoint p2 = new PositivePoint(-10, -10);
		System.out.println(p2.toString() + "입니다.");
	}
	
}
