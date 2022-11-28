import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnowFrame extends JFrame {

	// 생성자
	public SnowFrame() {
		
		setTitle("SnowFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel()); // 컨텐트팬 MyPanel로 설정
		
		setSize(600, 600);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("snowback.jpg");
		public Image img = icon.getImage();
		private final int SNOWNUM = 50; // 눈 개수
		private final int SNOWSIZE = 10; // 눈 크기 10px
		private Vector<Point> sv = new Vector<Point>();// 눈을 저장할 벡터 
		private SnowThread th = new SnowThread();
		
		public MyPanel() {
		
			// MyPanel에 변화가 생기면 이벤트리스너 발생
			this.addComponentListener(new ComponentAdapter() {
				
				@Override
				public void componentResized(ComponentEvent e) { // 이벤트 한 번만 불려지도록
					makeSnow();
					th.start();
					MyPanel.this.removeComponentListener(this);
				}
			});
			
			this.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(th.getStopFlag() == false)
						th.stopSnow();
					else
						th.resumeSnow();
				}
			});
		}
		
		class SnowThread extends Thread { // 눈 내리는 스레드, 눈의 위치를 이동해야 함
			
			private boolean stopFlag = false; // 스레드 멈출지
			public boolean getStopFlag() { return stopFlag; }
			
			public void stopSnow() { // 눈 멈추게 함
				stopFlag = true;
			}
			
			// ***
			synchronized public void resumeSnow() { // 눈 다시 내리게
				stopFlag = false;
				this.notify(); // 이 객체를 무한대기하는 스레드를 깨운다
			}
			
			// ***
			synchronized private void waitFlag() {
				try {
					this.wait(); // 기다리면서 중단된 상태, 꼭 try-catch, synchronized 키워드 사용해야함, 
								// 무한 대기, notify()가 불려질 때 까지
				} catch (InterruptedException e) {

				} 
			}
			
			
			@Override
			public void run() {
				
				while(true) {
					try {
						sleep(200);
						if (stopFlag == true)
							waitFlag();
						changePos();
						repaint();
					} 
					catch (InterruptedException e) { return; }
				}
			}
		}
		
		private void changePos() {
			
			for(int i = 0; i<sv.size(); i++) { // vector에 들어있는 만큼
				Point p = sv.get(i); // p는 vector를 가리키고 있음
				int dir = Math.random() > 0.5 ? 1 : -1; // 왼쪽으로 움직일지, 오른쪽으로 움직일지 
				p.x += dir*3; // 한 번에 3px 움직임
				if(p.x < 0 ) // 영역을 넘어가면
					p.x = 0; // 다시 잡아주기
				if(p.x > 600)
					p.x = 600;
				p.y += 7;
				if(p.y > this.getHeight()) // 영역 지나면
					p.y = 0; // 다시 잡아주기
			}
		}
		
		// 눈을 만드는 함수
		private void makeSnow() {
			
			for(int i = 0; i<SNOWNUM; i++) { // 눈 개수 만큼
				// 랜덤한 위치
				int x = (int)(Math.random()*500);
				int y = (int)(Math.random()*500);
				sv.add(new Point(x,y)); // 눈 위치 벡터에
			}
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
			
			g.setColor(Color.WHITE);
			for (int i = 0; i<sv.size(); i++) {
				g.fillOval(sv.get(i).x, sv.get(i).y, SNOWSIZE, SNOWSIZE);
			}
		}
		
	}
	public static void main(String[] args) {
		
		new SnowFrame();

	}

}

// flag와 wait, notify 같이 있어야, object class의 멤버
// wait, notify 같은 객체를 가르쳐야함
