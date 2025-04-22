package main.models;

public class Themes {
    private String selectedTheme;
    private String[] themeColors;

    // Constructor (Default Theme)
    public Themes() {
        setTheme("Chill"); // Default theme
    }

    // Set Theme
    public void setTheme(String theme) {
        switch (theme) {
            case "Chill":
                themeColors = new String[] { "#C5E1A5", "#424242", "#B39DDB", "#80CBC4" }; // Green, Charcoal, Lavender,
                                                                                           // Teal
                break;
            case "Dark Academia":
                themeColors = new String[] { "#3E2723", "#D7CCC8", "#6D4C41", "#BCAAA4" }; // Espresso, Beige, Maroon,
                                                                                           // Gold
                break;
            case "Beach":
                themeColors = new String[] { "#81D4FA", "#FFECB3", "#FFD54F", "#FFAB91" }; // Sky Blue, Sandy Beige, Sun
                                                                                           // Yellow, Coral Peach
                break;
            default:
                System.out.println("❌ Invalid theme! Please choose Chill, Dark Academia, or Beach.");
                return; // Exit method if theme is invalid
        }
        this.selectedTheme = theme;
        System.out.println("🎨 Theme set to: " + theme);
    }

    // Get Selected Theme
    public String getSelectedTheme() {
        return selectedTheme;
    }

    // Get Color Palette for Selected Theme
    public String[] getThemeColors() {
        return themeColors;
    }

    // Display Theme Colors (For Testing)
    public void displayThemeColors() {
        if (themeColors == null) {
            System.out.println("❌ No theme selected!");
            return;
        }
        System.out.println("🎨 " + selectedTheme + " Theme Colors:");
        System.out.println("Background: " + themeColors[0]);
        System.out.println("Text: " + themeColors[1]);
        System.out.println("Buttons: " + themeColors[2]);
        System.out.println("Accent: " + themeColors[3]);
    }
}
