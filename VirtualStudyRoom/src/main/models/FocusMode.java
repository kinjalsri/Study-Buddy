package main.models;

public class FocusMode {
    private boolean isEnabled;

    public FocusMode() {
        this.isEnabled = false;
    }

    public void enableFocus() {
        if (this.isEnabled) {
            System.out.println("Focus Mode is already ON");
        } else {
            this.isEnabled = true;
            System.out.println("Focus Mode is now ON");
        }
    }

    public void disableFocus() {
        if (!this.isEnabled) {
            System.out.println("Focus Mode is already OFF");
        } else {
            this.isEnabled = false;
            System.out.println("Focus Mode is now OFF");
        }
    }

    public boolean isFocusEnabled() {
        return this.isEnabled;
    }

}