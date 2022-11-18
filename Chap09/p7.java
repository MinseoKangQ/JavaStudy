import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class p7 extends JFrame { // JFrame 상속받기 

	class NorthPanel extends JPanel {
		
		public NorthPanel() {
			
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			
			add(new JLabel("수식입력"));
			add(new JTextField(18));
			
		}

	}
	
	class CenterPanel extends JPanel {
		
		public CenterPanel() {
			
			setLayout(new GridLayout(4, 4, 1, 1));
			
			for (int i = 0; i <= 9; i++) {
				add(new JButton(Integer.toString(i)));
			}
			
			add(new JButton("CE"));
			add(new JButton("계산"));
			
			JButton [] JButtonList = new JButton [] {
				new JButton("+"), new JButton("-"),
				new JButton("x"), new JButton("/")
			};
			
			
			for (int i = 0; i < 4; i++) {
			
				JButtonList[i].setBackground(Color.CYAN);
				JButtonList[i].setOpaque(true);
				add(JButtonList[i]);
			}
			
		}
	}
	
	class SouthPanel extends JPanel {
		
		public SouthPanel() {
			
			setBackground(Color.YELLOW);
			setLayout(new FlowLayout());
			add(new JLabel("계산 결과"));
			add(new JTextField(18));
			
		}
	}

	// 생성자
	public p7() {
		
		setTitle("계산기 프레임"); //타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫히면 프로그램 종료
		
		Container c = getContentPane(); // 컨텐트팬 받기
		c.setLayout(new BorderLayout()); // 배치관리자 설정
		
		// 패널들 등록하고 배치 
		c.add(new NorthPanel(), BorderLayout.NORTH); 
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(500, 300); // 창 크기 설정 
		setVisible(true); // 창 보이게
		
	}
	
	// main 함수
	public static void main(String [] args) {
		new p7();
	}
	
}
