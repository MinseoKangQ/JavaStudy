class Point2 {
	
	// 필드
	private int x,y; // x,y 좌표
	
	// 생성자 메소드 
	public Point2(int x, int y) { this.x = x; this.y = y; }
	
	// getter 메소드 
	public int getX() { return x; }
	public int getY() { return y; }
	
	// 좌표 이동시키는 메소드 
	protected void move(int x, int y) { this.x = x; this.y = y; }
	
}

class ColorPoint2 extends Point2 { // Point2를 상속받는 ColorPoint2
	
	// 필드
	private String color;
	
	// 생생자 메소드
	public ColorPoint2() {
		super(0,0); // 슈퍼클래스 생성자 호출
		this.color = "BLACK";
	}
	
	// 생생자 메소드
	public ColorPoint2(int x, int y) {
		super(x,y);
		this.color = "BLACK";
	}
	
	// setter 메소드
	public void setXY(int x, int y) { move(x,y); }
	public void setColor(String color) { this.color = color; }

	// getter 메소드
	public String getColor() { return color; }
	
	// 색과 좌표를 String으로 리턴하는 메소드 
	public String toString() { return (color + "색의 (" + getX() + ", " + getY() +")의 점");}
	
}

public class p6 {

	public static void main(String [] args) {
		ColorPoint2 zeroPoint = new ColorPoint2();
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10,10);
		cp.setXY(5,5);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");
	}
}
