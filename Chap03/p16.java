import java.util.Scanner;

public class p16 {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String str[] = {"가위", "바위", "보"};
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		
		while(true) {
			
			System.out.print("가위 바위 보! >> ");
			String userInput = scanner.nextLine();
			
			// "그만"이면 break
			if (userInput.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				break;
			}
			
			boolean isExist = false;
			
			// 가위/바위/보 중에 하나를 맞게 입력했는지 확인
			for (int i = 0; i<str.length; i++) {
				if (str[i].equals(userInput)) 
					isExist = true;
			}
			
			
			if (isExist) { // 제대로 입력했다면 
				// 랜덤으로 뽑고
				int computerSelNum = (int)(Math.random()*3);
				String computerInput = str[computerSelNum];
				
				// 누가 이겼는지 판단하고 누가 이겼는지 보기
				if (userInput.equals("가위") && computerInput.equals("바위"))
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 컴퓨터가 이겼습니다.");
				else if (userInput.equals("가위") && computerInput.equals("보"))
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 사용자가 이겼습니다.");
				else if (userInput.equals("뱌위") && computerInput.equals("가위"))
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 사용자가 이겼습니다.");
				else if (userInput.equals("뱌위") && computerInput.equals("보"))
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 컴퓨터가 이겼습니다.");
				else if (userInput.equals("보") && computerInput.equals("가위"))
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 컴퓨터가 이겼습니다.");
				else if (userInput.equals("보") && computerInput.equals("바위"))
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 사용자가 이겼습니다.");
				else
					System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerInput + ", 비겼습니다.");
			}
			
			else { // 아니라면 다시 입력할 것을 요구
				System.out.println("다시 입력하세요!!");
			}
			
		}
	}
}
