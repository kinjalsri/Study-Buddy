package main.services;

import main.models.Themes;

public class ThemesService {
    private Themes theme;

    public ThemesService() {
        theme = new Themes();
    }

    public void setTheme(String themeName) {
        theme.setTheme(themeName);
    }

    public void showCurrentTheme() {
        theme.displayThemeColors();
    }
}
