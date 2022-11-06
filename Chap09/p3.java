import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class p3 extends JFrame { // JFrame 상속받기 

	// 생성자
	public p3() {
		
		setTitle("p3"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫히면 프로그램 종료
		
		GridLayout grid = new GridLayout(1, 10); // 1행 10열의 Grid 배치관리자
		
		Container c = getContentPane(); // 컨텐트팬 받기
		c.setLayout(grid); // 배치관리자 grid로 설정 
		
		// JButton 생성 및 부착
		JButton [] btn = new JButton [10]; 
		for(int i=0; i<btn.length; i++) { // 0 ~ 9
			btn[i] = new JButton(Integer.toString(i));
			c.add(btn[i]); 
			
		}
		
		setSize(500, 200); // 프레임 크기 
		setVisible(true); // 프레임 보이게 
		
	}
	
	public static void main(String [] args) {
		new p3();
	}
	
}
