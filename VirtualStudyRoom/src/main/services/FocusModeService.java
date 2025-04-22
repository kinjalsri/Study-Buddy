package main.services;

import main.models.FocusMode;
import java.awt.*;

public class FocusModeService {
    private FocusMode focusMode;

    public FocusModeService() {
        this.focusMode = new FocusMode();
    }

    public void enableFocusMode() {
        focusMode.enableFocus();
        System.out.println("🔒 Focus Mode is ON. Stay focused!");

        try {
            Robot robot = new Robot();
            while (focusMode.isFocusEnabled()) {
                robot.mouseMove(500, 500); // Moves the mouse to a fixed point
                Thread.sleep(3000); // Prevents system from detecting inactivity
            }
        } catch (Exception e) {
            System.out.println("❌ Error controlling focus mode.");
        }
    }

    public void disableFocusMode() {
        focusMode.disableFocus();
        System.out.println("📖 Focus Mode is OFF. You can switch tabs.");
    }
}
