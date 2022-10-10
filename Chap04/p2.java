import java.util.Scanner;

class Grade {
	
	// 필드
	private int math, science, english;
	
	// 생성자 메소드
	Grade (int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	// 평균을 계산하여 리턴하는 메소드
	public int average() {
		return ((math + science + english) / 3);
	}
}

public class p2 {

	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력 >> ");
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		
		Grade me = new Grade(math, science, english);
		System.out.println("평균은 " + me.average()); 
	}
}
