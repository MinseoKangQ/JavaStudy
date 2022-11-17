import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p2 extends JFrame { // JFrame을 상속받음

	// 생성자
	public p2() {
		
		setTitle("p2"); // 타이틀 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료
		
		Container c = getContentPane(); // 컨텐트팬 받기
		c.setLayout(new FlowLayout()); // 배치관리자 설정
		
		c.setBackground(Color.GREEN); // 컨테이너 배경색 설정
		
		MyMouseListener listener = new MyMouseListener(); // 마우스 리스너 생성
		c.addMouseListener(listener); // 마우스 리스너 등록
		c.addMouseMotionListener(listener); // 마우스 모션 리스너 등록
		
		setSize(400, 250); // 창 크기 설정
		setVisible(true);  // 창 보이게
		
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener { // MouseAdapter와 MouseMotionListener

		// MouseListener 구현
		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent e) { }

		@Override
		public void mouseReleased(MouseEvent e) { 
			Component c = (Component)e.getSource();
			c.setBackground(Color.GREEN);	
		}

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }
		
		// MouseMotionListener 구현
		@Override
		public void mouseDragged(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseMoved(MouseEvent e) { }
		
	}
	
    // main 함수
	public static void main(String [] args) {
		
		new p2();
		
	}
}
