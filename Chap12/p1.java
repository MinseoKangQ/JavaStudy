import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p1 extends JFrame {
    
	private MyPanel panel = new MyPanel();
	private boolean flag = true;
	
    public p1() {
    	
        setTitle("p1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 300);
        setVisible(true);
        
    }
    
    class MyPanel extends JPanel{
    	private ImageIcon icon = new ImageIcon("snowback.jpg");
        private Image img = icon.getImage();
        private JButton button = new JButton("Hide/Show");
        private boolean Flag = true;
        
        public MyPanel() {
        	
        	setLayout(new FlowLayout());
        	add(button);
        	
        	button.addActionListener(new ActionListener() {
        		
        		@Override
        		public void actionPerformed(ActionEvent e) {
        			flag = !flag; // flag가 true 이면 false로, flag가 false이면 true로
        			MyPanel.this.repaint();
        		}
        	});
        	
        }
    	
        @Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		if(flag == true)
    			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    	}
    }
    
    public static void main(String [] args) {
    	new p1();
    }
}
