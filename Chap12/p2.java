import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p2 extends JFrame {
    
	private MyPanel panel = new MyPanel();
	private boolean flag = true;
	
    public p2() {
    	
        setTitle("p2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 300);
        setVisible(true);
        
    }
    
    class MyPanel extends JPanel {
    	
    	private ImageIcon icon = new ImageIcon("snowback.jpg");
        private Image img = icon.getImage();
        int x, y;
        
        public MyPanel() { setLayout(null); }
    	
    	public void paintComponent(Graphics g) {
    		
    		super.paintComponent(g);
    		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    		addMouseMotionListener(new MouseAdapter() {
    			public void mouseDragged(MouseEvent e) {
    				x = e.getX();
    				y = e.getY();
    				repaint();
    			}
    		});
    		
    		g.setColor(Color.GREEN);
    		g.fillOval(x, y, 20, 20);
    	}
    }
    
    
    public static void main(String [] args) {
    	
    	new p2();
    	
    }
}
