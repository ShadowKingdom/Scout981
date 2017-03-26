package scout981.controller;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import scout981.Main;

public class ControllerInterface {
	private Controller[] ca;
	
	public ControllerInterface() {
		ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
	}
	
	public void printControllerLists() {
		for(int i = 0; i < ca.length; i++) {
			Main.logInfo(ca[i].getName());
		}
	}
	
	//Doesn't work
	public void refreshControllerList() {
		ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
	}
}
