class TV2 {
	
	// 필드 
	private int size;
	
	// 생성자 메소드 (매개변수 있음)
	public TV2(int size) { this.size = size; }
	
	// getter 메소드 
	protected int getSize() { return size; }
	
}

class ColorTV2 extends TV2 { // TV2를 상속받는 ColorTV2
	
	// 필드 
	private int color;
	
	// 생성자 메소드 (매개변수 있음)
	public ColorTV2(int size, int color) {
		super(size);
		this.color = color;
	}
	
	// getter 메소드
	protected int getColor() { return color; }
	
}

class IPTV extends ColorTV2 {  // ColorTV를 상속받는 IPTV
	
	// 필드 
	private String ip;
	
	// 생성자 메소드 (매개변수 있음)
	public IPTV(String ip, int size, int color) {
		super(size, color);
		this.ip = ip;
	}
	
	// getter 메소드
	protected String getIP() { return ip; }
	
	// 속성을 보여주는 메소드
	public void printProperty() {
		System.out.println("나의 IPTV는 " + getIP() + " 주소의 " + getSize() + "인치 " + getColor() + "컬러");
	}
		
}

public class p2 {
	
	public static void main(String [] args) {
		IPTV iptv = new IPTV("192.0.0.0", 32, 2024);
		iptv.printProperty();
	}
	
}
