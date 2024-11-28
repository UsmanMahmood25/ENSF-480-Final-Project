package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignUp_LoginUI extends JPanel {

    public SignUp_LoginUI(CardLayout cardLayout, JPanel mainPanel) {

        setLayout(null);
        int textSize = (int) (0.0275 * MainUI.getFrameWidth());
        int textFieldSize = (int) (0.0175 * MainUI.getFrameWidth());
        int buttonWidth = (int) (0.25 * MainUI.getFrameWidth());
        int buttonHeight = (int) (0.08 * MainUI.getFrameHeight());
        int inputFieldWidth = (int) (0.4 * MainUI.getFrameWidth());
        int inputFieldHeight = (int) (0.075 * MainUI.getFrameHeight());

        // Placeholder text behavior using focus listener
        FocusListener placeholderFocusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField field = (JTextField) e.getComponent();
                if (field.getText().equals(field.getName())) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField field = (JTextField) e.getComponent();
                if (field.getText().isEmpty()) {
                    field.setText(field.getName());
                    field.setForeground(Color.GRAY);
                }
            }
        };

        // Login Segment
        JLabel loginLabel = new JLabel("Login");
        int loginLabelX = (int) (0.075 * MainUI.getFrameWidth());
        int loginLabelY = (int) (0.05 * MainUI.getFrameHeight());
        loginLabel.setBounds(loginLabelX, loginLabelY, inputFieldWidth, inputFieldHeight);
        loginLabel.setFont(new Font("Arial", Font.BOLD, textSize));
        add(loginLabel);

        // Login Username
        JTextField loginUsernameField = new JTextField("Username");
        loginUsernameField.setName("Username");
        int loginUsernameX = (int) (0.075 * MainUI.getFrameWidth());
        int loginUsernameY = (int) (0.15 * MainUI.getFrameHeight());
        loginUsernameField.setBounds(loginUsernameX, loginUsernameY, inputFieldWidth, inputFieldHeight);
        loginUsernameField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        loginUsernameField.setForeground(Color.GRAY);
        loginUsernameField.addFocusListener(placeholderFocusListener);
        add(loginUsernameField);

        // Login Password
        JPasswordField loginPasswordField = new JPasswordField("Password");
        loginPasswordField.setName("Password");
        int loginPasswordX = (int) (0.075 * MainUI.getFrameWidth());
        int loginPasswordY = (int) (0.25 * MainUI.getFrameHeight());
        loginPasswordField.setBounds(loginPasswordX, loginPasswordY, inputFieldWidth, inputFieldHeight);
        loginPasswordField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        loginPasswordField.setForeground(Color.GRAY);
        loginPasswordField.addFocusListener(placeholderFocusListener);
        add(loginPasswordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        int loginButtonX = (int) (0.075 * MainUI.getFrameWidth());
        int loginButtonY = (int) (0.35 * MainUI.getFrameHeight());
        loginButton.setBounds(loginButtonX, loginButtonY, buttonWidth, buttonHeight);
        loginButton.setFont(new Font("Arial", Font.BOLD, textSize));
        add(loginButton);

        // Sign-Up Segment
        JLabel signUpLabel = new JLabel("Sign-Up");
        int signUpLabelX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpLabelY = (int) (0.05 * MainUI.getFrameHeight());
        signUpLabel.setBounds(signUpLabelX, signUpLabelY, inputFieldWidth, inputFieldHeight);
        signUpLabel.setFont(new Font("Arial", Font.BOLD, textSize));
        add(signUpLabel);

        // Sign-Up Username
        JTextField signUpUsernameField = new JTextField("Username");
        signUpUsernameField.setName("Username");
        int signUpUsernameX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpUsernameY = (int) (0.15 * MainUI.getFrameHeight());
        signUpUsernameField.setBounds(signUpUsernameX, signUpUsernameY, inputFieldWidth, inputFieldHeight);
        signUpUsernameField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        signUpUsernameField.setForeground(Color.GRAY);
        signUpUsernameField.addFocusListener(placeholderFocusListener);
        add(signUpUsernameField);

        // Sign-Up Password
        JPasswordField signUpPasswordField = new JPasswordField("Password");
        signUpPasswordField.setName("Password");
        int signUpPasswordX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpPasswordY = (int) (0.25 * MainUI.getFrameHeight());
        signUpPasswordField.setBounds(signUpPasswordX, signUpPasswordY, inputFieldWidth, inputFieldHeight);
        signUpPasswordField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        signUpPasswordField.setForeground(Color.GRAY);
        signUpPasswordField.addFocusListener(placeholderFocusListener);
        add(signUpPasswordField);

        // Confirm Password
        JPasswordField confirmPasswordField = new JPasswordField("Confirm Password");
        confirmPasswordField.setName("Confirm Password");
        int confirmPasswordX = (int) (0.525 * MainUI.getFrameWidth());
        int confirmPasswordY = (int) (0.35 * MainUI.getFrameHeight());
        confirmPasswordField.setBounds(confirmPasswordX, confirmPasswordY, inputFieldWidth, inputFieldHeight);
        confirmPasswordField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        confirmPasswordField.setForeground(Color.GRAY);
        confirmPasswordField.addFocusListener(placeholderFocusListener);
        add(confirmPasswordField);

        // Sign-Up Button
        JButton signUpButton = new JButton("Sign-Up");
        int signUpButtonX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpButtonY = (int) (0.45 * MainUI.getFrameHeight());
        signUpButton.setBounds(signUpButtonX, signUpButtonY, buttonWidth, buttonHeight);
        signUpButton.setFont(new Font("Arial", Font.BOLD, textSize));
        add(signUpButton);

        // Home Page Redirect Button
        JButton homeButton = new JButton("Return Home");
        int homeButtonX = (int) (0.375 * MainUI.getFrameWidth());
        int homeButtonY = (int) (0.75 * MainUI.getFrameHeight());
        homeButton.setBounds(homeButtonX, homeButtonY, buttonWidth, buttonHeight);
        homeButton.setFont(new Font("Arial", Font.BOLD, textSize));
        add(homeButton);

        // Action listeners for buttons
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Login Successful!"));
        signUpButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Sign-Up Successful!"));
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
     
    }
}


// Two segments, Sign-Up or Login on same Page
