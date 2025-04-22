package main.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThemesScreen extends JPanel // extends JPanel
{

    public ThemesScreen(JFrame mainFrame) {
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
        JLabel titleLabel = new JLabel("THEMES");

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
        System.err.println(a + " " + b + " " + textWidth + " " + textHeight);
        // Set bounds for titleLabel

        titleLabel.setBounds(a, b, textWidth, textHeight);
        this.setLayout(null); // required for setBounds
        this.add(titleLabel);

        Font buttonFont = new Font("Courier New", Font.BOLD, 20);

        JButton darkButton = new JButton("→ DARK");
        darkButton.setFont(buttonFont);
        darkButton.setForeground(Color.BLACK);
        darkButton.setBackground(new Color(0xF8DDEB)); // Match background for transparent feel
        darkButton.setBorderPainted(false);
        darkButton.setFocusPainted(false);
        darkButton.setBounds(105, 90, 160, 30); // Adjust x, y as needed
        this.add(darkButton);

        JButton chillButton = new JButton("→ CHILL");
        chillButton.setFont(buttonFont);
        chillButton.setForeground(Color.BLACK);
        chillButton.setBackground(new Color(0xF8DDEB));
        chillButton.setBorderPainted(false);
        chillButton.setFocusPainted(false);
        chillButton.setBounds(105, 120, 160, 30);
        this.add(chillButton);

        JButton rainButton = new JButton("→ RAIN");
        rainButton.setFont(buttonFont);
        rainButton.setForeground(Color.BLACK);
        rainButton.setBackground(new Color(0xF8DDEB));
        rainButton.setBorderPainted(false);
        rainButton.setFocusPainted(false);
        rainButton.setBounds(105, 150, 160, 30);
        this.add(rainButton);

        JButton beachButton = new JButton("→ BEACH");
        beachButton.setFont(buttonFont);
        beachButton.setForeground(Color.BLACK);
        beachButton.setBackground(new Color(0xF8DDEB));
        beachButton.setBorderPainted(false);
        beachButton.setFocusPainted(false);
        beachButton.setBounds(105, 180, 160, 30);
        this.add(beachButton);

        ImageIcon BackIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room5.png"); // Put full path if needed

        Image smallBackImg = BackIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Small size
        ImageIcon smallBackIcon = new ImageIcon(smallBackImg);

        JButton BackButton = new JButton(smallBackIcon);
        BackButton.setBorderPainted(false);
        BackButton.setFocusPainted(false);
        BackButton.setContentAreaFilled(false);

        // Coordinates for monitor's bottom-right inside the background image
        int monitorX = x + 110;
        int monitorY = y + 140;
        int monitorWidth = 180;
        int monitorHeight = 120;
        int margin = 5;

        BackButton.setBounds(
                monitorX + monitorWidth - smallBackIcon.getIconWidth() - margin,
                monitorY + monitorHeight - smallBackIcon.getIconHeight() - margin - 40,
                smallBackIcon.getIconWidth(),
                smallBackIcon.getIconHeight());

        this.add(BackButton); // Add it AFTER background for visibility

        BackButton.addActionListener(e -> {
            mainFrame.setContentPane(new HomeScreen(mainFrame));
            mainFrame.revalidate();
        });

        add(background);

    }

}
