import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class p1 extends JFrame { // JFrame을 상속받음

	// 생성자 
	public p1() {
		
		setTitle("p1"); // 타이틀 생성 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료
		
		Container c = getContentPane(); // 컨텐트팬 받기
		c.setLayout(new FlowLayout()); // 배치관리자 설정
		
		JLabel la = new JLabel("사랑해"); // 레이블 생성
		la.setSize(50, 30); // 레이블 사이즈 설정
		c.add(la); // 레이블 컨텐트팬에 붙이기
		
		la.addMouseListener(new MyMouseListener()); // 마우스 리스너 등록, c에 붙이면 안됨
		
		setSize(500, 200); // 창 크기 설정
		setVisible(true); // 창 보이게
		
	}
	
	public class MyMouseListener extends MouseAdapter { // MouseAdapter를 상속받음
		
		@Override
		// 마우스가 레이블 위에 올라가면 텍스트 바뀜
		public void mouseEntered(MouseEvent e) {
			JLabel j = (JLabel)e.getSource(); 
			j.setText("Love Java");
			
		}
		
		// 마우스가 레이블에서 내려오면 텍스트 바뀜
		public void mouseExited(MouseEvent e) {
			JLabel j = (JLabel)e.getSource();
			j.setText("사랑해");
		}
		
	}
	
	// main 함수
	public static void main(String [] args) {
		new p1();
	}
	
}
