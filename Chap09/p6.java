import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class p6 extends JFrame { // JFrame 상속받기 
	
	// 생성자
	public p6() {
		
		setTitle("p6"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫히면 프로그램 종료
		
		Container c = getContentPane(); // 컨텐트팬 받기
		c.setLayout(null); // 배치관리자 제거 
		
		// JLabel 생성, 배경색 설정, 부착
		for(int i=0; i<20; i++) { 
			
			// 해당 숫자를 문자열로, JLabel 내부 숫자로 설정
			String text = Integer.toString(i);
			JLabel label = new JLabel(text);
			
			// JLabel 내부 글자 가운데 정렬 
			label.setHorizontalAlignment(JLabel.CENTER);
			
			// 배경색 보이게 설정
			label.setOpaque(true); 
			
			// 배경색 설정
			label.setBackground(Color.BLUE);
			
			// 크기와 위치 설정
			label.setSize(10, 10);
			int x = (int)(Math.random()*200) + 50;
			int y = (int)(Math.random()*200) + 50;
			label.setLocation(x,y);
			
			// 부착
			c.add(label);
		
		}	
		
		setSize(300, 300); // 프레임 크기 
		setVisible(true); // 프레임 보이게 
		
	}
	
	public static void main(String [] args) {
		new p6();
	}
	
}
