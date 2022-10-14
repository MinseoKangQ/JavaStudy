// p8

import java.util.Scanner;

class Phone {
	
	// 필드 
	private String name; // 이름 
	private String tel; // 전화번호
	
	// 생성자 메소드 (매개변수 없음)
	public Phone() {}
	
	// setter 메소드
	public void set(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	// getter 메소드
	public String getName() { return name; }
	public String getTel() { return tel; }
	
}

public class PhoneBook {
	
	// 필드 
	private int numOfPerson; // 인원수
	private Phone phones []; // Phone 레퍼런스 선언 
	private Scanner scanner = new Scanner(System.in);
	
	// 생성자 메소드 (매개변수 없음), 인원수 입력받고 세팅
	public PhoneBook() {
		
		System.out.print("인원수 >> ");
		numOfPerson = scanner.nextInt();
		
		this.phones = new Phone[numOfPerson];
		for(int i = 0; i<phones.length; i++) {
			phones[i] = new Phone();
		}
		
		for(int i = 0; i<numOfPerson; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력) >> ");
			String name = scanner.next();
			String tel = scanner.next();
			phones[i].set(name, tel);
		}
		
		System.out.println("저장되었습니다...");
		
	}
	

	public void run() { // 실행 함수
		
		while(true) { // 무한반복 
			
			System.out.print("검색할 이름 >> ");
			String searchName = scanner.next();
			
			if (searchName.equals("그만")) break; // 종료 
			
			boolean isExist = false;
			
			// 검색
			for (int i = 0; i<phones.length; i++) {
				if (searchName.equals(phones[i].getName())) { // 이름 일치하는 것이 있으면 
					System.out.println(phones[i].getName() + "의 번호는 " + phones[i].getTel() + "입니다.");
					isExist = true;
				}		
			}
			// 이름 일치하는 것이 없으면
			if (!isExist) System.out.println(searchName + "이 없습니다.");
		}
	}
	
	public static void main(String [] args) {
		
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.run();
		
	}
}
