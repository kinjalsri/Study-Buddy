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

public class GoalsScreen extends JPanel {
    public GoalsScreen(JFrame mainFrame) {
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
        JLabel titleLabel = new JLabel("GOALS");

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

        ImageIcon addIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room4.png"); // Put full path if needed

        Image smalladdImg = addIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Small size
        ImageIcon smalladdIcon = new ImageIcon(smalladdImg);

        JButton addButton = new JButton(smalladdIcon);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.setContentAreaFilled(false);

        // Coordinates for monitor's bottom-right inside the background image
        int monitorX = x + 110;
        int monitorY = y + 140;
        int monitorWidth = 180;
        int monitorHeight = 120;
        int margin = 5;

        addButton.setBounds(
                monitorX + monitorWidth - smalladdIcon.getIconWidth() - margin + 5,
                monitorY + monitorHeight - smalladdIcon.getIconHeight() - margin - 40,
                smalladdIcon.getIconWidth(),
                smalladdIcon.getIconHeight());

        this.add(addButton); // Add it AFTER background for visibility

        ImageIcon BackIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room5.png"); // Put full path if needed

        Image smallBackImg = BackIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Small size
        ImageIcon smallBackIcon = new ImageIcon(smallBackImg);

        JButton backButton = new JButton(smallBackIcon);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);

        backButton.setBounds(
                monitorX + margin + 5, // bottom-left of monitor
                monitorY + monitorHeight - smallBackIcon.getIconHeight() - margin - 41,
                smallBackIcon.getIconWidth(),
                smallBackIcon.getIconHeight());
        this.add(backButton);

        backButton.addActionListener(e -> {
            mainFrame.setContentPane(new HomeScreen(mainFrame));
            mainFrame.revalidate();
        });

        add(background);
    }

}
