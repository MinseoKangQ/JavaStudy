class TV {
	
	// 필드 
	private String maker;
	private int year;
	private int inch;
	
	// 생성자 메소드 
	TV(String maker, int year, int inch) {
		this.maker = maker;
		this.year = year;
		this.inch = inch;
	}
	
	// Getter 메소드 
	public String getMaker() { return maker; }
	public int getYear() { return year; }
	public int getInch() { return inch; }
	
	// 정보 보여주는 메소드 
	public void show() {
		System.out.println(getMaker() + "에서 만든 " + getYear() + "년형 " + getInch() + "인치 TV");
	}
}

public class p1 {
	
	public static void main(String [] args) {
		TV myTV = new TV("LG", 2017, 32);
		myTV.show();
	}
}
