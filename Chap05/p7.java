class Point3 {
	
	// 필드
	private int x,y; // x,y 좌표
	
	// 생성자 메소드 
	public Point3(int x, int y) { this.x = x; this.y = y; }
	
	// getter 메소드 
	public int getX() { return x; }
	public int getY() { return y; }
	
	// 좌표 이동시키는 메소드 
	protected void move(int x, int y) { this.x = x; this.y = y; }
	
}

class Point3D extends Point3 { // Point3를 상속받는 Point3D
	
	// 필드
	private int z; // z 좌표
	
	// 생생자 메소드
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	// 좌표 이동 메소드
	public void moveUp() { z++; }
	public void moveDown() { z--; }
	public void move(int x, int y, int z) {
		move(x,y);
		this.z = z;
	}
	
	// setter 메소드
	public void setXY(int x, int y) { move(x,y); }

	// getter 메소드
	public int getZ() { return z; }
	
	// 색과 좌표를 String으로 리턴하는 메소드 
	public String toString() { return ("(" + getX() + ", " + getY() + ", " + getZ() + ")의 점"); }
	
}

public class p7 {

	public static void main(String [] args) {
		Point3D p = new Point3D(1,2,3); // 1, 2, 3은 각각 x, y, z축의 값
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(); // z축으로 위쪽 이동 
		System.out.println(p.toString() + "입니다.");
		
		p.moveDown(); // z축으로 아래쪽 이동 
		p.move(10,10); // x, y 축으로 이동
		System.out.println(p.toString() + "입니다.");
		
		p.move(100, 200, 300); // x, y, z 축으로 이동 
		System.out.println(p.toString() + "입니다.");
	}
}
