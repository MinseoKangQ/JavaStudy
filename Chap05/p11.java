import java.util.Scanner;

abstract class Calc {
	
	// 필드 
	protected int a, b;
	
	// a와 b값을 설정하는 메소드
	protected void setValue(int a, int b) {
		this.a  = a; this.b = b;
	}
	
	// 추상 메소드
	public abstract int caculate();
	
}

class Add extends Calc{
	
	public Add(int a, int b) { 
		super.setValue(a, b);
	}
	
	@Override
	public int caculate() { return a+b; }
	
}

class Sub extends Calc{
	
	public Sub(int a, int b) { 
		super.setValue(a, b);
	}
	
	@Override
	public int caculate() { return a-b; }
		
}

class Mul extends Calc{
	
	public Mul(int a, int b) { 
		super.setValue(a, b);
	}
	
	@Override
	public int caculate() { return a*b; }
		
}

class Div extends Calc{
	
	public Div(int a, int b) { 
		super.setValue(a, b);
	}
		
	@Override
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
			Add add = new Add(a, b);
			System.out.println(add.caculate());
			break;
		case "-":
			Sub sub = new Sub(a, b);
			System.out.println(sub.caculate());
			break;
		case "*":
			Mul mul = new Mul(a, b);
			System.out.println(mul.caculate());
			break;
		case "/":
			Div div = new Div(a, b);
			System.out.println(div.caculate());
			break;
		}
	}
}
