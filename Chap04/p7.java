// p7

import java.util.Scanner;

class Day {
	
	// 필드
	private String work; // 하루의 할 일을 나타내는 문자열
	
	// setter 메소드
	public void set(String work) { this.work = work; }
	
	// getter 메소드
	public String get() { return work; }
	
	// 할 일을 보여주는 메소드
	public void show() {
		if(work == null) System.out.println("없습니다.");
		else System.out.println(work + "입니다.");
	}
	
}

public class MonthSchedule {
	
	// 필드
	private int nDays; // 한 달의 날짜
	
	private Day [] days; // Day 객체 배열 레퍼런스 선언 
	private Scanner scanner = new Scanner(System.in);
	
	// 생성자 메소드
	public MonthSchedule(int nDays) { 
		this.nDays = nDays;		
		this.days = new Day [nDays]; // 배열 공간 할당
		for(int i=0; i<days.length; i++) {
			days[i] = new Day(); // 생성자 호출
		}	
	}
	
	private void input() { // 날짜와 할 일을 입력하는 메소드
		
		System.out.print("날짜(1~30)?");
		int day = scanner.nextInt();
		System.out.print("할일(빈칸없이입력)?");
		String work = scanner.next();
		
		day--;
		if(day < 0 || day > nDays) { // 0~29 만 유효
			System.out.println("날짜 잘못 입력하였습니다.!");			
			return;
		}
		days[day].set(work);
		
	}
	
	private void view() { // 보여주는 메소드
		
		System.out.print("날짜(1~30)?");
		int day = scanner.nextInt();
		
		day--;
		if(day < 0 || day > nDays) { // 0~29 만 유효
			System.out.println("날짜 잘못 입력하였습니다.!");			
			return;
		}
		
		System.out.print((day+1) + "일의 할 일은 " );
		days[day].show();
		
	}
	
	private void finish() { // 종료하는 메소드 
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() { // 메인 실행 함
		System.out.println("이번달 스케쥴 관리 프로그램.");

		while(true) {
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >> ");
			int menu = scanner.nextInt();
			switch(menu) {
			case 1: input(); break;
			case 2: view(); break;
			case 3: finish(); return;
			default : 
				System.out.println("잘못입력하였습니다.");
			}
			System.out.println();
		}		
	}
	
	public static void main(String[] args) {
		
		MonthSchedule april = new MonthSchedule(30); // 4월달의 할 일
		april.run();
		
	}

}