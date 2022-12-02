import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p3 extends JFrame {

	private ImageIcon icon = new ImageIcon("apple.jpg");
	private JLabel la = new JLabel(icon);
	
	public p3() {
		
		setTitle("p3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		la.setSize(icon.getIconHeight(), icon.getIconWidth());
		la.setLocation(0,0);
		
		MyMouseListener ml = new MyMouseListener();
		la.addMouseListener(ml);
		la.addMouseMotionListener(ml);
		
		c.add(la);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		
		private Point startP = null;
		
		@Override
		public void mousePressed(MouseEvent e) {
			startP = e.getPoint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			Point endP = e.getPoint();
			Component la = (JComponent)(e.getSource());
			Point p = la.getLocation();
			la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
			la.getParent().repaint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			Point endP = e.getPoint();
			Component la = (JComponent)(e.getSource());
			Point p = la.getLocation();
			la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
			la.getParent().repaint();
		}
	}
	
	public static void main(String [] args) {
		
		new p3();
		
	}
	
}
