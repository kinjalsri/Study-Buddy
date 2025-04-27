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
import main.services.MusicService;
import main.models.Music;

public class MusicScreen extends JPanel // extends JPanel
{
    private final MusicService musicService = new MusicService();
    private JButton playPauseButton;

    public MusicScreen(JFrame mainFrame) {
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

        JLabel titleLabel = new JLabel("MUSIC");

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

        // Album cover to be displayed inside the monitor
        ImageIcon albumIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room8.jpeg"); // Replace with your image path
        Image albumImage = albumIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // Smaller image
        ImageIcon scaledAlbumIcon = new ImageIcon(albumImage);

        JLabel albumLabel = new JLabel(scaledAlbumIcon);

        int albumX = monitorX + (monitorWidth - 80) / 2 - 5; // 80 = album width
        int albumY = monitorY + (monitorHeight - 80) / 2 - 90;

        albumLabel.setBounds(albumX, albumY, 100, 100);
        this.add(albumLabel);

        ImageIcon playIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room7.png"); // Replace with your path
        Image scaledPlayImage = playIcon.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledPlayIcon = new ImageIcon(scaledPlayImage);
        ImageIcon pauseIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room6.png"); // Replace with your path
        Image scaledPauseImage = pauseIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledPauseIcon = new ImageIcon(scaledPauseImage);

        playPauseButton = new JButton(scaledPlayIcon);// this is what i have added right now
        if (musicService.isCurrentlyPlaying()) {
            playPauseButton.setIcon(new ImageIcon(scaledPauseImage));
        } else {
            playPauseButton.setIcon(new ImageIcon(scaledPlayImage));
        }

        playPauseButton.setBorderPainted(false);
        playPauseButton.setFocusPainted(false);
        playPauseButton.setContentAreaFilled(false);

        // Position: center between BackButton and Rewind (you'll add Rewind later)
        int playX = monitorX + (monitorWidth / 2) - 20; // Center horizontally
        int playY = monitorY + monitorHeight - 85; // Adjust vertically to align with Back

        playPauseButton.setBounds(playX, playY, 40, 40);

        this.add(playPauseButton);

        ImageIcon rewindIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/room9.png");
        Image scaledRewindImg = rewindIcon.getImage().getScaledInstance(42, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledRewindIcon = new ImageIcon(scaledRewindImg);

        JButton rewindButton = new JButton(scaledRewindIcon);
        rewindButton.setBorderPainted(false);
        rewindButton.setFocusPainted(false);
        rewindButton.setContentAreaFilled(false);

        rewindButton.setBounds(playX - 60, playY, 40, 40);
        this.add(rewindButton);

        playPauseButton.addActionListener(e -> {
            if (!musicService.isCurrentlyPlaying()) {
                musicService.playLoFi(); // Play the music
                playPauseButton.setIcon(scaledPauseIcon);
            } else {
                musicService.stopMusic();
                playPauseButton.setIcon(scaledPlayIcon);
            }
        });

        BackButton.addActionListener(e -> {
            mainFrame.setContentPane(new HomeScreen(mainFrame));
            mainFrame.revalidate();
        });

        rewindButton.addActionListener(e -> {
            musicService.rewind();
            playPauseButton.setIcon(scaledPauseIcon); // Reset icon
        });

        add(background);
    }

}
