package scout981.controller;

import java.util.HashMap;

import edu.wpi.first.wpilibj.XboxController;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.ControllerEvent;
import net.java.games.input.ControllerListener;
import scout981.Main;

public class ControllerInterface implements ControllerListener {
	private Controller[] controller;
	private static XboxController[] gamepad;
	private Component[] components;
	private HashMap<Integer, Controller> controllersHashMap = new HashMap<Integer, Controller>(); 
	
	public ControllerInterface() {
		gamepad = new XboxController[6];
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
	}
	
	public void printControllerInput() {
		for(int i = 0; i < gamepad.length; i++) {
			if(controller[i].getType() == Controller.Type.GAMEPAD) {
				Component[] component = controller[i].getComponents();
				if(component[i].isRelative()) {
					System.out.println(component[i].getName());
				}
			}
		}
	}
	
	public void printControllerList() {
		for(int i = 0; i < controller.length; i++) {
			Main.logInfo(controller[i].getName());
		}
	}

	//joysticks are absolute; 
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
