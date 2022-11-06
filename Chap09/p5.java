import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class p5 extends JFrame { // JFrame 상속받기 
	
	// 생성자
	public p5() {
		
		setTitle("p5"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫히면 프로그램 종료
		
		GridLayout grid = new GridLayout(4, 4); // 4행 4열의 Grid 배치관리자
		
		Container c = getContentPane(); // 컨텐트팬 받기
		c.setLayout(grid); // 배치관리자 grid로 설정 
		
		// JLabel 생성, 배경색 설정, 부착
		for(int i=0; i<16; i++) { 
			
			// 색을 배열로
			Color[] color = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, 
					        Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, 
					        Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
					        Color.YELLOW, Color.GRAY, Color.BLUE, Color.RED };
			
			// 해당 숫자를 문자열로, JLabel 내부 숫자로 설정
			String text = Integer.toString(i);
			JLabel b = new JLabel(text);
			
			// JLabel 내부 글자 가운데 정렬 
			b.setHorizontalAlignment(JLabel.CENTER);
			
			// 배경색 보이게 설정
			b.setOpaque(true); 
			
			// 배경색 설정
			b.setBackground(color[i]);
			
			// 부착
			c.add(b);
		
		}	
		
		setSize(500, 200); // 프레임 크기 
		setVisible(true); // 프레임 보이게 
		
	}
	
	public static void main(String [] args) {
		new p5();
	}
	
}
