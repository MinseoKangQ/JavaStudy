import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class p2 extends JFrame { // JFrame 상속받기 
	
	// 생성자
	public p2() {
		
		setTitle("p2"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫히면 프로그램 종료
		
		Container c = getContentPane(); // 컨텐트팬 받기
		
		c.setLayout(new BorderLayout(5,7)); // 배치관리자 설정 
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("Center"), BorderLayout.CENTER);
		
		setSize(400, 200); // 프레임 크기 
		setVisible(true); // 프레임 보이게 
	}
	
	public static void main(String[] args) {
		new p2();
	}

}
