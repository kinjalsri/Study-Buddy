
package main.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class HomeScreen extends JPanel {

    public HomeScreen(JFrame mainFrame) {
        setLayout(null);
        setBackground(new Color(0xF8DDEB)); // same baby pink background

        // Set image as background
        ImageIcon bgIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room1.png");
        Image resizedImage = bgIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel background = new JLabel(resizedIcon);

        // Centering the image based on panel size

        int imageWidth = 400;
        int imageHeight = 400;
        int width = 420;
        int height = 420;

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        background.setBounds(x, y, imageWidth, imageHeight);
        add(background);
        JLabel titleLabel = new JLabel("Study Buddy");

        // Set font and color
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 24)); // adjust size as needed
        titleLabel.setForeground(Color.BLACK);

        // Measure string width with current font
        FontMetrics fm = titleLabel.getFontMetrics(titleLabel.getFont());
        int textWidth = fm.stringWidth(titleLabel.getText());
        int textHeight = fm.getHeight();

        // Calculate x, y for centering (frame = 420 x 420)
        int a = (420 - textWidth) / 2 + 5;

        int b = 60; // adjust to place it vertically near the top of screen area

        // Set bounds for titleLabel

        titleLabel.setBounds(a, b, textWidth, textHeight);
        this.setLayout(null); // required for setBounds
        this.add(titleLabel);

        Font buttonFont = new Font("Courier New", Font.BOLD, 20);

        JButton timerButton = new JButton("→ TIMER");
        timerButton.setFont(buttonFont);
        timerButton.setForeground(Color.BLACK);
        timerButton.setBackground(new Color(0xF8DDEB)); // Match background for transparent feel
        timerButton.setBorderPainted(false);
        timerButton.setFocusPainted(false);
        timerButton.setBounds(105, 90, 160, 30); // Adjust x, y as needed
        this.add(timerButton);

        // MUSIC button
        JButton musicButton = new JButton("→ MUSIC");
        musicButton.setFont(buttonFont);
        musicButton.setForeground(Color.BLACK);
        musicButton.setBackground(new Color(0xF8DDEB));
        musicButton.setBorderPainted(false);
        musicButton.setFocusPainted(false);
        musicButton.setBounds(105, 120, 160, 30);
        this.add(musicButton);

        // GOALS button
        JButton goalsButton = new JButton("→ GOALS");
        goalsButton.setFont(buttonFont);
        goalsButton.setForeground(Color.BLACK);
        goalsButton.setBackground(new Color(0xF8DDEB));
        goalsButton.setBorderPainted(false);
        goalsButton.setFocusPainted(false);
        goalsButton.setBounds(105, 150, 160, 30);
        this.add(goalsButton);

        // exit button
        JButton exitButton = new JButton("→ EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(new Color(0xF8DDEB));
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setBounds(105, 180, 160, 30);
        this.add(exitButton);

        ImageIcon focusIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room3.png"); // Put full path if needed

        Image smallFocusImg = focusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Small size
        ImageIcon smallFocusIcon = new ImageIcon(smallFocusImg);

        JButton focusButton = new JButton(smallFocusIcon);
        focusButton.setBorderPainted(false);
        focusButton.setFocusPainted(false);
        focusButton.setContentAreaFilled(false);

        // Coordinates for monitor's bottom-right inside the background image
        int monitorX = x + 110;
        int monitorY = y + 140;
        int monitorWidth = 180;
        int monitorHeight = 120;
        int margin = 5;

        focusButton.setBounds(
                monitorX + monitorWidth - smallFocusIcon.getIconWidth() - margin,
                monitorY + monitorHeight - smallFocusIcon.getIconHeight() - margin - 40,
                smallFocusIcon.getIconWidth(),
                smallFocusIcon.getIconHeight());

        this.add(focusButton); // Add it AFTER background for visibility

        add(background); // add last so it's behind everything

        // Button listeners
        timerButton.addActionListener(e -> {
            mainFrame.setContentPane(new TimerScreen(mainFrame));
            mainFrame.revalidate();

        });

        goalsButton.addActionListener(e -> {
            mainFrame.setContentPane(new GoalsScreen(mainFrame));
            mainFrame.revalidate();

        });

        exitButton.addActionListener(e -> {
            mainFrame.setContentPane(new ThemesScreen(mainFrame));
            mainFrame.revalidate();

        });

        musicButton.addActionListener(e -> {
            mainFrame.setContentPane(new MusicScreen(mainFrame));
            mainFrame.revalidate();
        });

        focusButton.addActionListener(e -> System.out.println("Focus Mode On"));
    }
}