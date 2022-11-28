import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class MyApp extends JFrame {

	// 생성자
	public MyApp() {
		setTitle("그래픽");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel()); // 컨텐트팬 변경
		
		setSize(600, 600);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("snowback.jpg");
		private Image img = icon.getImage();
		
		// 생성자
		public MyPanel() {
			
			this.setBackground(Color.GRAY);
			
//			setLayout(null); // 배치관리자 제거
//			ImageIcon icon = new ImageIcon("cap.png");
//			JLabel myImg = new JLabel(icon);
//			myImg.setSize(icon.getIconWidth(), icon.getIconHeight()); // 그림 크기만큼
//			
//			myImg.setLocation(100, 100);
//			add(myImg);
			
			add(new JButton("hello"));
			
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setClip(100, 100, 200, 200); // 클리핑 영역 
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null); // 0, 0부터 시작, 크기는 원래 이미지 크기로
			g.setColor(Color.BLUE);
			g.fillRect(10, 10, 100, 100);
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("Jokerman", Font.ITALIC, 50));
			g.drawString("Java is fantastic", 130, 130);
			g.setColor(Color.YELLOW);
			g.drawLine(0,0, this.getWidth(), this.getHeight());
			
			// 원 그리기 (사각형에 내접하는 원 그림)
			for (int i = 0; i<10; i++) {
				g.drawOval(0, 0, 50*i, 50*i);
			}
			
			//System.out.print("@"); // MyPanel이 언제 불려지는지 확인하기 위해
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new MyApp();

	}

}
