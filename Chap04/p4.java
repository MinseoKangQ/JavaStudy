class Rectangle {
	
	// 필드
	private int x, y, width, height;
	
	// 생성자 메소드 (매개변수 없음)
	public Rectangle() {}

	// 생성자 메소드 (매개변수 있음)
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	// getter 메소드
	public int getX() { return x; }
	public int getY() { return y; }	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	// 사각형의 면적을 리턴하는 메소드
	public int square() { return width * height; }
	
	// 사각형의 정보를 출력하는 메소드
	public void show() {
		System.out.println("(" + getX() + "," + getY() +")에서 크기가 " + getWidth() + "x" + getHeight() + "인 사각형");
	}
	
	// 매개변수로 받은 r이 현 사각형 안에 있는지 확인하는 메소드
	public boolean contains(Rectangle r) {
		if (r.x > this.x && r.y > this.y) {
			if ((r.x + r.width < this.x + this.width) && (r.y + r.height < this.y + this.height)) {
				return true;
			}
		}
		return false;
	}
}


public class p4 {

	public static void main(String [] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);
		
		r.show();
		System.out.println("s의 면적은 " + s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s을 포함합니다.");
	}
}
