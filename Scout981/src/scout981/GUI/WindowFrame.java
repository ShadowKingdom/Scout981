package scout981.GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import scout981.Main;

public class WindowFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public WindowFrame(String title, boolean mainWindow) {
		super(title);
		
		if(mainWindow) {
			setBounds(0, 0, 800, 680);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					Main.getInstance().stopApp();
				}
			});
		}
		pack();
	}
	
}
