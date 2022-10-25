import java.util.Scanner;

abstract class Converter { // 추상 메소드가 포함되어 있으므로 추상 클래스임 
	
	abstract protected double convert(double src); // 추상 메소드 
	abstract protected String getSrcString(); // 추상 메소드 
	abstract protected String getDestString(); // 추상 메소드 
	protected double ratio; // 비율
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
		System.out.print(getSrcString() + "을 입력하세요 >> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("변환 결과 : " + res + getDestString() + "입니다.");
		scanner.close();
	}
	
}

class Won2Dollar extends Converter { // Converter를 상속받는 Won2Dollar
	
	Scanner scanner = new Scanner(System.in);
	
	// 생성자 메소드
	// ratio는 슈퍼클래스에서 protected 멤버로 선언되었기 때문에 서브클래스에서 접근 가능 
	public Won2Dollar(double ratio) { this.ratio = ratio; } 
	
	// 원을 달러로 바꿔주는 함수 
	@Override
	protected double convert(double src) { return src/ratio; }
	
	@Override
	protected String getSrcString() { return "원"; }
	
	@Override
	protected String getDestString() { return "달러"; }
	
}

public class p3 {

	public static void main(String [] args) {
		Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원
		toDollar.run();
	}
	
}
