package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HomeUI extends JPanel {

    public HomeUI(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Add a label
        JLabel label = new JLabel("Welcome to the Home Screen");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 0;
        add(label, gbc);

        // Add a button to go to the Sign-Up.Login screen
        JButton redirectButton1 = new JButton("Go to Sign-Up/Login Screen");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(redirectButton1, gbc);
        // Add a button to go to the Theater screen
        JButton redirectButton2 = new JButton("Go to Theater Screen");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(redirectButton2, gbc);

        // Add action listener to redirect1 button
        redirectButton1.addActionListener(e -> cardLayout.show(mainPanel, "Sign-Up/Login"));
        // Add action listener to redirect2 button
        redirectButton2.addActionListener(e -> cardLayout.show(mainPanel, "Theater"));
    }
}

// After Home Page, redirect to either Sign-Up/Login or Theater