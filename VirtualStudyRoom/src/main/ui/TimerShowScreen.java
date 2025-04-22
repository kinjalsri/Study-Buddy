package main.ui;

import javax.swing.*;
import java.awt.*;

public class TimerShowScreen extends JPanel {
    private JLabel timerLabel;
    private JLabel messageLabel;
    private volatile boolean timerRunning = true;
    private volatile boolean isPaused = false;

    public TimerShowScreen(JFrame mainFrame, int minutes) {
        setLayout(null);
        setBackground(new Color(0xF8DDEB)); // same baby pink background

        // Set image as background
        ImageIcon bgIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room1.png");
        Image resizedImage = bgIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel background = new JLabel(resizedIcon);

        int imageWidth = 400;
        int imageHeight = 400;
        int width = 420;
        int height = 420;

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        background.setBounds(x, y, imageWidth, imageHeight);
        JLabel titleLabel = new JLabel("TIMER");

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

        // === TIMER LABEL IN CENTER ===
        timerLabel = new JLabel(minutes + ":00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Courier New", Font.BOLD, 32));
        timerLabel.setForeground(Color.BLACK);
        // Monitor screen inside the image (same values as your design)
        int monitorX = x + 110;
        int monitorY = y + 140;
        int monitorWidth = 180;
        int monitorHeight = 120;

        // Label size
        int labelWidth = 120;
        int labelHeight = 50;

        // Centered position within the monitor
        int labelX = monitorX + (monitorWidth - labelWidth) / 2;
        int labelY = monitorY + (monitorHeight - labelHeight) / 2 - 90;

        timerLabel.setBounds(labelX, labelY, labelWidth, labelHeight);

        this.add(timerLabel);

        messageLabel = new JLabel("Stay focused🌈", SwingConstants.CENTER);

        messageLabel.setFont(new Font("Courier New", Font.BOLD, 18));
        messageLabel.setForeground(Color.BLACK);
        int messageWidth = 200; // instead of labelWidth
        messageLabel.setBounds(labelX - 40, labelY + labelHeight - 5, messageWidth, 30);
        this.add(messageLabel);

        // === TIMER THREAD with seconds ===
        int totalSeconds = minutes * 60;

        new Thread(() -> {
            for (int i = totalSeconds; i >= 0 && timerRunning; i--) {

                // === Check for pause ===
                while (isPaused && timerRunning) {
                    try {
                        Thread.sleep(200); // wait while paused
                    } catch (InterruptedException e) {
                        SwingUtilities.invokeLater(() -> timerLabel.setText("⏹ Interrupted!"));
                        return;
                    }
                }
                final int secondsLeft = i;
                SwingUtilities.invokeLater(() -> {
                    int min = secondsLeft / 60;
                    int sec = secondsLeft % 60;
                    timerLabel.setText(String.format("%02d:%02d", min, sec));
                });

                try {
                    Thread.sleep(1000); // update every second
                } catch (InterruptedException e) {
                    SwingUtilities.invokeLater(() -> timerLabel.setText("⏹ Interrupted!"));
                    return;
                }
            }
            if (timerRunning) {
                SwingUtilities.invokeLater(() -> {

                    timerLabel.setFont(new Font("Courier New", Font.BOLD, 20)); // Smaller size to fit the monitor
                    timerLabel.setText("🎉 Time's up!");
                    messageLabel.setFont(new Font("Courier New", Font.BOLD, 18));
                    messageLabel.setForeground(Color.BLACK);

                    messageLabel.setBounds(labelX - 40, labelY + labelHeight - 5, messageWidth, 30);
                    messageLabel.setText("Take a break ☕");
                });
            }
        }).start();

        int margin = 5;
        ImageIcon BackIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room5.png"); // Put full path if needed

        Image smallBackImg = BackIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Small size
        ImageIcon smallBackIcon = new ImageIcon(smallBackImg);

        JButton BackButton = new JButton(smallBackIcon);
        BackButton.setBorderPainted(false);
        BackButton.setFocusPainted(false);
        BackButton.setContentAreaFilled(false);

        BackButton.setBounds(
                monitorX + monitorWidth - smallBackIcon.getIconWidth() - margin,
                monitorY + monitorHeight - smallBackIcon.getIconHeight() - margin - 40,
                smallBackIcon.getIconWidth(),
                smallBackIcon.getIconHeight());

        this.add(BackButton); // Add it AFTER background for visibility

        BackButton.addActionListener(e -> {
            timerRunning = false;
            System.out.println("Timer stopped");
            mainFrame.setContentPane(new HomeScreen(mainFrame));
            mainFrame.revalidate();
        });

        ImageIcon pauseIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room6.png");
        ImageIcon playIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room7.png");

        Image scaledPauseImg = pauseIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image scaledPlayImg = playIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        ImageIcon scaledPauseIcon = new ImageIcon(scaledPauseImg);
        ImageIcon scaledPlayIcon = new ImageIcon(scaledPlayImg);
        JButton pauseButton = new JButton(scaledPauseIcon);
        pauseButton.setBorderPainted(false);
        pauseButton.setFocusPainted(false);
        pauseButton.setContentAreaFilled(false);

        pauseButton.setBounds(
                monitorX + margin + 5, // bottom-left of monitor
                monitorY + monitorHeight - scaledPauseIcon.getIconHeight() - margin - 32,
                smallBackIcon.getIconWidth(),
                smallBackIcon.getIconHeight());

        pauseButton.addActionListener(e -> {
            isPaused = !isPaused;
            pauseButton.setIcon(isPaused ? scaledPlayIcon : scaledPauseIcon);
        });

        this.add(pauseButton);

        this.add(background); // must be added last to stay in back

    }
}