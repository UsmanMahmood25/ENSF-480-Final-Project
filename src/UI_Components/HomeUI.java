package UI_Components;

import javax.swing.*;
import java.awt.*;

public class HomeUI extends JPanel {

    public HomeUI(CardLayout cardLayout, JPanel mainPanel) {

        setLayout(null);
        int textSize = (int) (0.0275 * MainUI.getFrameWidth());
        int buttonWidth = (int) (0.4 * MainUI.getFrameWidth());
        int buttonHeight = (int) (0.25 * MainUI.getFrameHeight());

        // Add a label
        JLabel label = new JLabel("Welcome to the Home Screen");
        int labelPositionX = (int) (0.325 * MainUI.getFrameWidth());
        int labelPositionY = (int) (0.01 * MainUI.getFrameHeight());
        int labelWidth = (int) (0.4 * MainUI. getFrameWidth());
        int labelHeight = (int) (0.3 * MainUI.getFrameHeight());
        label.setBounds(labelPositionX, labelPositionY, labelWidth, labelHeight);
        label.setFont(new Font("Arial", Font.BOLD, textSize));
        add(label);

        // Add a button to go to the Sign-Up.Login screen
        JButton redirectButton1 = new JButton("Go to Sign-Up/Login Screen");
        int buttonPostionX1 = (int) (0.55 * MainUI.getFrameWidth());
        int buttonPostionY1 = (int) (0.4 * MainUI.getFrameHeight());
        redirectButton1.setBounds(buttonPostionX1, buttonPostionY1, buttonWidth, buttonHeight);
        redirectButton1.setFont(new Font("Arial", Font.BOLD, textSize));
        add(redirectButton1);

        // Add a button to go to the Theater screen
        JButton redirectButton2 = new JButton("Go to Theater Screen");
        int buttonPostionX2 = (int) (0.05 * MainUI.getFrameWidth());
        int buttonPostionY2 = (int) (0.4 * MainUI.getFrameHeight());
        redirectButton2.setBounds(buttonPostionX2, buttonPostionY2, buttonWidth, buttonHeight);
        redirectButton2.setFont(new Font("Arial", Font.BOLD, textSize));
        add(redirectButton2);

        // Add action listener to redirect1 button
        redirectButton1.addActionListener(e -> cardLayout.show(mainPanel, "Sign-Up/Login"));
        // Add action listener to redirect2 button
        redirectButton2.addActionListener(e -> cardLayout.show(mainPanel, "Theater"));
    }
}

// After Home Page, redirect to either Sign-Up/Login or Theater