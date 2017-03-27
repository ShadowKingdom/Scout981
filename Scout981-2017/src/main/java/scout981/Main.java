package scout981;

import scout981.gui.WindowFrame;
import scout981.controller.ControllerInterface;

public class Main extends Thread {
	public static ControllerInterface ci;
	
	private static WindowFrame mainWindow;
	private static Main instance;
	private volatile boolean running;
	
	public Main() {
		super("[Scout Client]");
		if(instance == null) {
			ci = new ControllerInterface();
			instance = this;
			mainWindow = new WindowFrame("Scout 981", true);
		} else {
			return;
		}
	}
	
	public void preInitiatialization() {
		ci.printControllerLists();
	}

	public void run() {
		mainWindow.setVisible(true);
		
		while(running) {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ci.printControllerLists();
			logInfo("Running...");
		}
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		mainWindow = new WindowFrame("Scout 981", true);
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
