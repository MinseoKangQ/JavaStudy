import javax.swing.JFrame;

public class p1 extends JFrame { // JFrame 상속받기 

	// 생성자
	public p1() {
		setTitle("Let's study Java"); // 타이틀
		setSize(400, 200); // 프레임 크기 
		setVisible(true); // 프레임 보이게 
	}
	
	public static void main(String [] args) {
		new p1();
	}
}
