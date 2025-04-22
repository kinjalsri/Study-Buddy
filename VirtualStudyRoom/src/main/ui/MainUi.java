package main.ui;

import javax.swing.*;
import java.awt.*;

public class MainUi extends JFrame {

    public MainUi() {
        setTitle("Study Buddy");
        setSize(420, 420);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("VirtualStudyRoom/src/main/ui/room2.jpeg");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(0xF8DDEB));

        // Set the initial screen (HomeScreen)
        setContentPane(new HomeScreen(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainUi::new); // cleaner launch
    }
}
