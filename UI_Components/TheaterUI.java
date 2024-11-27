package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TheaterUI extends JPanel {

    public TheaterUI(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Add a label
        JLabel label = new JLabel("Welcome to the Theater Screen");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        // Add a button to go to the Info screen
        JButton redirectButton = new JButton("Go to Home Screen");
        gbc.gridy = 1;
        add(redirectButton, gbc);

        // Add action listener to redirect button
        redirectButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
    }
}