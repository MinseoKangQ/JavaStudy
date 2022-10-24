class TV {
	
	// 필드 
	private int size;
	
	// 생성자 메소드 (매개변수 있음)
	public TV(int size) { this.size = size; }
	
	// getter 메소드 
	protected int getSize() { return size; }
	
}

class ColorTV extends TV { // TV를 상속받는 ColorTV
	
	// 필드 
	private int color;
	
	// 생성자 메소드 (매개변수 있음)
	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}
	
	// getter 메소드
	public int getColor() { return color; }
	
	// 속성을 보여주는 메소드
	public void printProperty() {
		System.out.println(getSize() + "인치 " + getColor() + "컬러");
	}
	
}


public class p1 {
	
	public static void main(String [] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
	}
	
}
