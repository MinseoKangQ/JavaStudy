class Point {
	
	// 필드
	private int x,y; // x, y 좌표 
	
	// 생성자 메소드 
	public Point(int x, int y) { this.x = x; this.y = y; }
	
	// getter 메소드 
	public int getX() { return x; }
	public int getY() { return y; }
	
	// 좌표 이동시키는 메소드 
	protected void move(int x, int y) { this.x = x; this.y = y; }
	
}

class ColorPoint extends Point { // Point를 상속받는 ColorPoint
	
	// 필드
	private String color;
	
	// 생생자 메소드 
	public ColorPoint(int x, int y, String color) {
		super(x, y); // 슈퍼클래스 생성자 호출
		this.color = color;
	}
	
	// setter 메소드
	public void setXY(int x, int y) { move(x,y); }
	public void setColor(String color) { this.color = color;}
	
	// getter 메소드
	public String getColor() { return color; }
	
	// 색과 좌표를 String으로 리턴하는 메소드 
	public String toString() { return (getColor() + "색의 (" + getX() + ", " + getY() + ")의 점"); }
	
}

public class p5 {

	public static void main(String [] args) {
		
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		String str = cp.toString();
		System.out.println(str + "입니다.");
	}
	
}
