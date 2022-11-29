import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChickenGameFrame extends JFrame {
	
	public ChickenGameFrame() {
		
		super("치킨 사격 게임");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		
		setSize(300, 300);
		setVisible(true);
		
		p.startGame();
	}

	public static void main(String[] args) {
		
		new ChickenGameFrame();

	}

}

class GamePanel extends JPanel {
	
	private TargetThread targetThread1 = null;
	private TargetThread targetThread2 = null;
	private JLabel baseLabel = new JLabel(); // 발사대
	private JLabel bulletLabel = new JLabel(); // 총알
	
	ImageIcon icon = new ImageIcon("chicken.jpg");
	private JLabel targetLabel1 = new JLabel(icon); // 사격 목표가 되는 이미지 레이블(치킨)
	private JLabel targetLabel2 = new JLabel(icon); // 사격 목표가 되는 이미지 레이블(치킨)
	
	public GamePanel() {
		
		setLayout(null);
		
		baseLabel.setSize(40, 40);
		baseLabel.setBackground(Color.BLACK);
		baseLabel.setOpaque(true);
		add(baseLabel);
		
		bulletLabel.setSize(10, 10);
		bulletLabel.setBackground(Color.RED);
		bulletLabel.setOpaque(true);
		add(bulletLabel);
		
		targetLabel1.setSize(icon.getIconWidth(), icon.getIconHeight()); // 이미지의 크기만한 레이블 크기 설정
		add(targetLabel1);
		
		targetLabel2.setSize(icon.getIconWidth(), icon.getIconHeight()); // 이미지의 크기만한 레이블 크기 설정
		add(targetLabel2);
		
		this.addKeyListener(new KeyAdapter() { // 엔터 누르면 총알 발사
			
			BulletThread bulletThread = null;
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyChar() == '\n') {
					//if(targetThread == null) return; // targetThread가 null이면 끝내라
					//if(bulletThread == null || !bulletThread.isAlive())  {// bulletThread가 돌아가면 만들기 || bulletThread가 죽은 경우에
						bulletThread = new BulletThread(bulletLabel, targetLabel1, targetLabel2, targetThread1, targetThread2);
						bulletThread.start();
					//}
				}
			}
		});
		
	}
	
	public void startGame() { // 이 함수가 호출될 때는 이미 스윙 프레임이 완성되어 출력된 상태, 컴포넌트들의 크기가 결정된 상태
		
		// 레이블의 위치 설정 
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight() - 40); // this는 게임패널
		bulletLabel.setLocation(this.getWidth()/2-5, baseLabel.getY() - 10);
		targetLabel1.setLocation(0, 0);
		targetLabel2.setLocation(0, 70);
		
		// TargetThread 객체 생성 및 실행 시작
		targetThread1 = new TargetThread(targetLabel1, 20); // targetLabel을 알려줘야함
		targetThread1.start();
		
		targetThread2 = new TargetThread(targetLabel2, 10); // targetLabel을 알려줘야함
		targetThread2.start();
		
		// 포커스 주기
		this.setFocusable(true);
		this.requestFocus();
	}
	
	// Start of class TargetThread
	// TargetThread는 targetLabel을 불러야함
	class TargetThread extends Thread { 
		
		private JLabel targetLabel = null;
		private int delay;
		
		public TargetThread(JLabel targetLabel, int delay) { // 생성자
			
			this.targetLabel = targetLabel;
			this.delay = delay;
		} 
		
		@Override
		public void run() {
			
			while(true) { // 계속 움직여야함
				
				// 현재 위치 얻기
				int x = targetLabel.getX() + 5;
				int y = targetLabel.getY();
				
				if(x > GamePanel.this.getWidth()) // 폭 넘어가면
					targetLabel.setLocation(0, targetLabel.getY()); // 다시 0,0으로
				else
					targetLabel.setLocation(x, y);
				
				targetLabel.getParent().repaint();
				
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// 맞으면 타겟 이미지 다시 0,0으로 가져다놓기 
					targetLabel.setLocation(0, targetLabel.getY());
				}
			}
		}
		
	} // end of class TargetThread
	
	
	// Start of class BulletThread
	// Enter 키 치면 총알 발사 시작
	class BulletThread extends Thread {
		
		private JLabel bulletLabel = null;
		private JLabel targetLabel1 = null;
		private JLabel targetLabel2 = null;
		private TargetThread targetThread1 = null;
		private TargetThread targetThread2 = null;
		
		public BulletThread(JLabel bulletLabel, JLabel targetLabel1, JLabel targetLabel2, TargetThread targetThread1, TargetThread targetThread2) { // 치킨에게 맞있는지 알아야해서 targetLabel도 알아야 함
																		// 움직이는걸 멈추도록 하려면 TargetThread에 대해서 알아야 함 
			this.bulletLabel = bulletLabel;
			this.targetLabel1 = targetLabel1;
			this.targetLabel2 = targetLabel2;
			this.targetThread1 = targetThread1;
			this.targetThread2 = targetThread2;
		}
		
		@Override 
		public void run() { // bulletLabel을 위로 한 번에 5픽셀씩 이동시키기, 치킨레이블과 충돌하는지 판단, 범위 벗어나면 범위체크
			
			while(true) {
				
				if (hit(targetLabel1)) { // 명중 시 할 일 
					targetThread1.interrupt(); // 치킨 멈춰라
					bulletLabel.setLocation(bulletLabel.getParent().getWidth()/2-5, baseLabel.getY() - 10); // 총알 위치 재설정
					bulletLabel.getParent().repaint();
					return; // 스레드 종료
				}
				else if (hit(targetLabel2)) { // 명중 시 할 일 
					targetThread2.interrupt(); // 치킨 멈춰라
					bulletLabel.setLocation(bulletLabel.getParent().getWidth()/2-5, baseLabel.getY() - 10); // 총알 위치 재설정
					bulletLabel.getParent().repaint();
					return; // 스레드 종료
				}
				
				
				else { // 명중 안했으면
					int x = bulletLabel.getX();
					int y = bulletLabel.getY() - 5;
					if(y < 0)  { // 위의 영역을 벗어나면 
						bulletLabel.setLocation(bulletLabel.getParent().getWidth()/2-5, baseLabel.getY() - 10); // 총알 위치 재설정
						bulletLabel.getParent().repaint();
						return; // 스레드 종료
					}
					
					// 정상적인 범위 내에 움직이고 있으면
					bulletLabel.setLocation(x, y);
					bulletLabel.getParent().repaint();
				}
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) { }
			}
		}
			
			
	}

	
	private boolean hit(JLabel targetLabel) {
		if (targetContains(targetLabel, bulletLabel.getX(), bulletLabel.getY()) ||
				targetContains(targetLabel, bulletLabel.getX()+bulletLabel.getWidth()-1, 
						bulletLabel.getY() + bulletLabel.getHeight() -1))
			return true;
		else 
			return false;
			
	}
	
	private boolean targetContains(JLabel targetLabel, int x, int y) { // target이 x, y를 포함하는지 
		
		if(targetLabel.getX() <= x && (targetLabel.getX() + targetLabel.getWidth() - 1) >= x &&
				targetLabel.getY() <= y && (targetLabel.getY() + targetLabel.getHeight() -1) >= y)
			return true;
		else 
			return false;
		
	}
	// end of class BulletThread
}

