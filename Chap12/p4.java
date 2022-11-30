import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p4 extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public p4() {
		
		setTitle("p4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);

		setSize(500, 500);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("apple.jpg");
		private Image img = icon.getImage();
		int x, y;
		
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			setLayout(null);
			
			g.drawImage(img, x, y, img.getWidth(this), img.getHeight(this), this);
			
			addMouseMotionListener(new MouseMotionAdapter() {
				
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
			
		}
	}
	
	public static void main(String [] args) {
		
		new p4();
		
	}
	
}
