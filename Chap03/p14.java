import java.util.Scanner;

public class p14 {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String course [] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int score [] = {95, 88, 76, 62, 55};
		
		while(true) {
			
			// 과목 이름 입력받기
			System.out.print("과목 이름 >> ");
			String inputCourse = scanner.nextLine();
			
			// 종료 조건
			if (inputCourse.equals("그만")) break;
			
			boolean isExist = false;
			for (int i = 0; i<course.length; i++) {
				if (course[i].equals(inputCourse)) {
					System.out.println(course[i] + "의 점수는 " + score[i]);
					isExist = true;
				}
			}
			
			if (!isExist) System.out.println("없는 과목입니다."); //?
		}
	}
}
