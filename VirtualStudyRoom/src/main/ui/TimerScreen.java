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

import main.services.TimerService;

public class TimerScreen extends JPanel // extends JPanel
{
    public TimerScreen(JFrame mainFrame) {
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

        Font buttonFont = new Font("Courier New", Font.BOLD, 20);

        JButton timer1Button = new JButton("→ 15 MINS");
        timer1Button.setFont(buttonFont);
        timer1Button.setForeground(Color.BLACK);
        timer1Button.setBackground(new Color(0xF8DDEB)); // Match background for transparent feel
        timer1Button.setBorderPainted(false);
        timer1Button.setFocusPainted(false);
        timer1Button.setBounds(105, 90, 160, 30); // Adjust x, y as needed
        this.add(timer1Button);

        JButton timer2Button = new JButton("→ 20 MINS");
        timer2Button.setFont(buttonFont);
        timer2Button.setForeground(Color.BLACK);
        timer1Button.setBackground(new Color(0xF8DDEB));
        timer2Button.setBorderPainted(false);
        timer2Button.setFocusPainted(false);
        timer2Button.setBounds(105, 120, 160, 30);
        this.add(timer2Button);

        JButton timer3Button = new JButton("→ 25 MINS");
        timer3Button.setFont(buttonFont);
        timer3Button.setForeground(Color.BLACK);
        timer3Button.setBackground(new Color(0xF8DDEB));
        timer3Button.setBorderPainted(false);
        timer3Button.setFocusPainted(false);
        timer3Button.setBounds(105, 150, 160, 30);
        this.add(timer3Button);

        JButton timer4Button = new JButton("→ 50 MINS");
        timer4Button.setFont(buttonFont);
        timer4Button.setForeground(Color.BLACK);
        timer1Button.setBackground(new Color(0xF8DDEB));
        timer4Button.setBorderPainted(false);
        timer4Button.setFocusPainted(false);
        timer4Button.setBounds(105, 180, 160, 30);
        this.add(timer4Button);

        ImageIcon BackIcon = new ImageIcon("VirtualStudyRoom/src/main/ui/Room5.png"); // Put full path if needed

        Image smallBackImg = BackIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Small size
        ImageIcon smallBackIcon = new ImageIcon(smallBackImg);

        JButton BackButton = new JButton(smallBackIcon);
        BackButton.setBorderPainted(false);
        BackButton.setFocusPainted(false);
        BackButton.setContentAreaFilled(false);

        timer1Button.addActionListener(e -> {
            TimerService service = new TimerService();
            main.models.Timer timer = new main.models.Timer(15); // assuming you have a Timer model with a constructor

            TimerShowScreen showScreen = new TimerShowScreen(mainFrame, 15); // we'll add these params
            mainFrame.setContentPane(showScreen);
            mainFrame.revalidate();

            // Start timer in a background thread
            new Thread(() -> service.startTimer(timer)).start();
        });

        timer2Button.addActionListener(e -> {
            TimerService service = new TimerService();
            main.models.Timer timer = new main.models.Timer(25); // assuming you have a Timer model with a constructor

            TimerShowScreen showScreen = new TimerShowScreen(mainFrame, 25); // we'll add these params
            mainFrame.setContentPane(showScreen);
            mainFrame.revalidate();

            // Start timer in a background thread
            new Thread(() -> service.startTimer(timer)).start();
        });

        timer3Button.addActionListener(e -> {
            TimerService service = new TimerService();
            main.models.Timer timer = new main.models.Timer(30); // assuming you have a Timer model with a constructor

            TimerShowScreen showScreen = new TimerShowScreen(mainFrame, 30); // we'll add these params
            mainFrame.setContentPane(showScreen);
            mainFrame.revalidate();

            // Start timer in a background thread
            new Thread(() -> service.startTimer(timer)).start();
        });

        timer2Button.addActionListener(e -> {
            TimerService service = new TimerService();
            main.models.Timer timer = new main.models.Timer(50); // assuming you have a Timer model with a constructor

            TimerShowScreen showScreen = new TimerShowScreen(mainFrame, 50); // we'll add these params
            mainFrame.setContentPane(showScreen);
            mainFrame.revalidate();

            // Start timer in a background thread
            new Thread(() -> service.startTimer(timer)).start();
        });

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
