import java.util.Scanner;

class Add {
	
	// 필드 
	private int a, b; 
	
	// setter 메소드
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	// 클래스 목적에 맞는 연산을 실행하고 결과 리턴하는 메소드
	public int caculate() { return a+b; }
	
}

class Sub {
	
	// 필드 
		private int a, b; 
		
	// setter 메소드
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
		
	// 클래스 목적에 맞는 연산을 실행하고 결과 리턴하는 메소드
	public int caculate() { return a-b; }
		
}

class Mul {
	
		// 필드 
		private int a, b; 
			
		// setter 메소드
		public void setValue(int a, int b) {
			this.a = a;
			this.b = b;
		}
			
		// 클래스 목적에 맞는 연산을 실행하고 결과 리턴하는 메소드
		public int caculate() { return a*b; }
		
}

class Div {
	
	// 필드 
	private int a, b; 
		
	// setter 메소드
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
		
	// 클래스 목적에 맞는 연산을 실행하고 결과 리턴하는 메소드
	public int caculate() { return a/b; }
		
}


public class p11 {

	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operator = scanner.next();
		
		switch(operator) {
		
		case "+":
			Add add = new Add();
			add.setValue(a, b);
			System.out.println(add.caculate());
			break;
		case "-":
			Sub sub = new Sub();
			sub.setValue(a, b);
			System.out.println(sub.caculate());
			break;
		case "*":
			Mul mul = new Mul();
			mul.setValue(a, b);
			System.out.println(mul.caculate());
			break;
		case "/":
			Div div = new Div();
			div.setValue(a, b);
			System.out.println(div.caculate());
			break;
		}
	}
}
