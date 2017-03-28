package scout981.controller;

import edu.wpi.first.wpilibj.XboxController;

public class ProcessHandController {

       public static XboxController[] gamepad;

       public ProcessHandController() {
              gamepad = new XboxController[6];
       }

       public static boolean readButton (int pad, int buttonId) {
              boolean result = false;
              try {
                     result = gamepad[pad].getRawButton(buttonId);
              } catch (NullPointerException e) {
                     result = false;
              } finally {

                     result = false;

              }

              return result;

       }
}
