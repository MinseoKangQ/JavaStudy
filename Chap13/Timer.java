import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyApp extends JFrame{
	
	private JLabel text1 = new JLabel("0");
	private JLabel text2 = new JLabel("0");

	public MyApp() {
		
		super("스레드 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		text1.setSize(100, 40);
		text1.setLocation(50, 50);
		text2.setSize(100, 40);
		text2.setLocation(170, 50);
		
		c.add(text1);
		text1.setFont(new Font("Gothic", Font.ITALIC, 30));
		c.add(text2);
		text2.setFont(new Font("Gothic", Font.ITALIC, 30));
		
		setSize(300, 300);
		setVisible(true);
		
		TimerThread th1 = new TimerThread("aa", text1, 1000); // TimerThread 객체 생성
		th1.start();
		TimerThread th2 = new TimerThread("bb", text2, 100); // TimerThread 객체 생성
		th2.start();
		
		text1.addMouseListener(new MouseAdapter() {  
			
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌러지면 스레드 죽임
				
				System.out.println("mousePressed 실행하는 스레드 : " + Thread.currentThread().getName());
				// mouseEventDispatch 스레드가 돌고있음!
				
				// 스레드 객체가 죽었다고 해서 스레드 객체가 사라진 것은 아님
				// 스레드가 terminated 상태이면 다시 살릴 수 X
				if(th1.isAlive()) // 살아있으면 죽어라
					th1.interrupt();
				else // 살아있지 않으면 종료함을 표시해라
					System.out.println(th1.getName() + "는 종료하였습니다." + th1.getCount()); // ?
					
				
				
			}
			
		});
		
	}
	
	class TimerThread extends Thread { // Thread 클래스 상속받는다
		
		private JLabel text = null;
		private int delay = 0;
		private int count = 0;
		
		public TimerThread(String name, JLabel text, int delay) { // main 스레드가 이것을 실행중임
			
			super(name); // 상위 클래스의 생성자 이름 가짐
			this.text = text;
			this.delay = delay;
			System.out.println("생성자 : " + Thread.currentThread().getName());
			
		}
		
		public int getCount() { return count; }
		
		@Override
		public void run() { // 이것이 Thread 코드이다
			// run은 부르는 것 아님!!
			
			System.out.println(Thread.currentThread().getName());
			// kk 스레드가 이것을 실행중임
			
			while(true) {
				
				try {
					sleep(delay);
					count++;
					text.setText(Integer.toString(count));
//					if(Thread.currentThread().getName().equals("aa")) {
//						int x = (int)(Math.random()*text.getParent().getWidth());
//						int y = (int)(Math.random()*text.getParent().getHeight());
//						text.setLocation(x,y);
//					}
				} 
				catch (InterruptedException e) {
					System.out.println("interrupt 받았음");
					return; // run 함수를 끝낸다, terminate 상태로 만든다
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + "의 우선순위 = " + Thread.currentThread().getPriority());
		// main의 우선순위는 5
		// 
		new MyApp();

	}

}
