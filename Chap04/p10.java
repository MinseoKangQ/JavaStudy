// p10

import java.util.Scanner;

class Dictionary {
	
	private static String [] kor = { "사랑", "아기", "돈", "미래", "희망" };
	private static String [] eng = { "love", "baby", "money", "future", "hope" };
	public static String kor2Eng(String word) { // 검색코드 작성 
		
		for (int i = 0; i < kor.length; i++) {
			if (word.equals(kor[i])) return eng[i];
		}
		return "저의 사전에 없습니다.";
		
	}
	
}
public class DicApp {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("한영 단어 검색 프로그램입니다.");
		
		while(true) {
			
			System.out.print("한글 단어?" );
			String searchWord = scanner.next();
			
			if (searchWord.equals("그만")) break;
			
			// static 함수는 클래스명으로 접근 가능함을 이용
			System.out.println(searchWord + "은 " + Dictionary.kor2Eng(searchWord));
		}
		
		
	}
	
}
