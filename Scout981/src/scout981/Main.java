package scout981;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import scout981.controller.ControllerInterface;

public class Main extends Thread {
	public static ControllerInterface ci;
	
	private static JFrame jFrame;
	private static Main instance;
	private volatile boolean running;
	
	public Main() {
		super("[Scout Client]");
		if(instance == null) {
			ci = new ControllerInterface();
			instance = this;
			jFrame = new JFrame("Scout 981");
			jFrame.setBounds(0, 0, 800, 680);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					stopApp();
				}
			});
		} else {
			return;
		}
	}
	
	public void preInitiatialization() {
		ci.printControllerLists();
	}

	public void run() {
		jFrame.setVisible(true);
		
		while(running) {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ci.refreshControllerList();
			ci.printControllerLists();
			logInfo("Running...");
		}
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		super.start();
	}
	
	public synchronized void stopApp() {
		if(running) running = false;
		System.out.println("Stopping Application...");
		try {
			join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void logInfo(String message) {
		System.out.println(Main.getInstance().getName() +" [Info] " + message);
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.preInitiatialization();
		main.start();
	}
}
