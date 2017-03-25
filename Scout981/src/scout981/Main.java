package scout981;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main implements Runnable {
	JFrame jFrame;
	Thread thread;
	private static Main instance;
	private volatile boolean running;
	
	public Main() {
		if(instance == null) {
			instance = this;
			jFrame = new JFrame("Scout 981");
			jFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					
				}
			});
		} else {
			return;
		}
	}

	public void run() {
		jFrame.setVisible(true);
		
		while(running) {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(thread.getName() + "Running...");
		}
	}
	
	public void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread("Scout Client");
		thread.start();
	}
	
	public void stop() {
		if(running) {
			running = false;
		}
		
		try {
			System.out.println(thread.getName() + "Stopping threads...");
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		
	}
}
