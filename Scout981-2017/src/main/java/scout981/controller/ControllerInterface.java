package scout981.controller;

import java.util.HashMap;

import org.apache.poi.poifs.crypt.HashAlgorithm;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.ControllerEvent;
import net.java.games.input.ControllerListener;
import net.java.games.input.DirectAndRawInputEnvironmentPlugin;
import scout981.Main;

public class ControllerInterface implements ControllerListener {
	private Controller[] controllers;
	private Component[] components;
	private HashMap<Integer, Controller> controllersHashMap = new HashMap<Integer, Controller>(); 
	
	public ControllerInterface() {
		controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
	}
	
	public void printControllerLists() {
		for(int i = 0; i < controllers.length; i++) {
			Main.logInfo(controllers[i].getName());
		}
	}

	public void controllerAdded(ControllerEvent e) {
		Controller controller = e.getController();
		components = controller.getComponents();
		for(int i = 0; i < components.length; i++) {
			System.out.println(components[i].getName() + " " + components[i].getIdentifier().getName());
		}
	}

	public void controllerRemoved(ControllerEvent e) {
		
	}
}
