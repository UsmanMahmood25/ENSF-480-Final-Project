package UI_Components;

// Two segments, Sign-Up or Login on same Page

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;

public class SignUp_LoginUI extends JPanel {

    public SignUp_LoginUI(CardLayout cardLayout, JPanel mainPanel) {

        // Setting Default Values for the UI
        setLayout(null);
        int textSize = (int) (0.0275 * MainUI.getFrameWidth());
        int textFieldSize = (int) (0.0165 * MainUI.getFrameWidth());
        int buttonWidth = (int) (0.25 * MainUI.getFrameWidth());
        int buttonHeight = (int) (0.08 * MainUI.getFrameHeight());
        int inputFieldWidth = (int) (0.4 * MainUI.getFrameWidth());
        int inputFieldHeight = (int) (0.075 * MainUI.getFrameHeight());

        // Placeholder focus listener for JPasswordField
        FocusListener passwordPlaceholderListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JPasswordField field = (JPasswordField) e.getComponent();
                String text = new String(field.getPassword());
                if (text.equals(field.getName())) {
                    field.setText("");
                    field.setEchoChar('*'); // Show dots when typing
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                JPasswordField field = (JPasswordField) e.getComponent();
                if (field.getPassword().length == 0) {
                    field.setEchoChar((char) 0); // Remove dots for placeholder
                    field.setText(field.getName());
                    field.setForeground(Color.GRAY);
                }
            }
        };

        // Placeholder text behavior for JTextField
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
        JTextField loginUsernameField = new JTextField("Username (Email)");
        loginUsernameField.setName("Username (Email)");
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
        loginPasswordField.setEchoChar((char) 0); // Initially no dots
        loginPasswordField.addFocusListener(passwordPlaceholderListener);
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
        JTextField signUpUsernameField = new JTextField("Name");
        signUpUsernameField.setName("Name");
        int signUpUsernameX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpUsernameY = (int) (0.15 * MainUI.getFrameHeight());
        signUpUsernameField.setBounds(signUpUsernameX, signUpUsernameY, inputFieldWidth, inputFieldHeight);
        signUpUsernameField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        signUpUsernameField.setForeground(Color.GRAY);
        signUpUsernameField.addFocusListener(placeholderFocusListener);
        add(signUpUsernameField);

        // Sign-Up Name
        JTextField signUpNameField = new JTextField("Username (Email)");
        signUpNameField.setName("Username (Email)");
        int signUpNameX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpNameY = (int) (0.25 * MainUI.getFrameHeight());
        signUpNameField.setBounds(signUpNameX, signUpNameY, inputFieldWidth, inputFieldHeight);
        signUpNameField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        signUpNameField.setForeground(Color.GRAY);
        signUpNameField.addFocusListener(placeholderFocusListener);
        add(signUpNameField);

        // Sign-Up Address
        JTextField signUpAddressField = new JTextField("Address");
        signUpAddressField.setName("Address");
        int signUpAddressX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpAddressY = (int) (0.35 * MainUI.getFrameHeight());
        signUpAddressField.setBounds(signUpAddressX, signUpAddressY, inputFieldWidth, inputFieldHeight);
        signUpAddressField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        signUpAddressField.setForeground(Color.GRAY);
        signUpAddressField.addFocusListener(placeholderFocusListener);
        add(signUpAddressField);

        // Sign-Up Password
        JPasswordField signUpPasswordField = new JPasswordField("Password");
        signUpPasswordField.setName("Password");
        int signUpPasswordX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpPasswordY = (int) (0.45 * MainUI.getFrameHeight());
        signUpPasswordField.setBounds(signUpPasswordX, signUpPasswordY, inputFieldWidth, inputFieldHeight);
        signUpPasswordField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        signUpPasswordField.setForeground(Color.GRAY);
        signUpPasswordField.setEchoChar((char) 0); // Initially no dots
        signUpPasswordField.addFocusListener(passwordPlaceholderListener);
        add(signUpPasswordField);

        // Confirm Password
        JPasswordField confirmPasswordField = new JPasswordField("Confirm Password");
        confirmPasswordField.setName("Confirm Password");
        int confirmPasswordX = (int) (0.525 * MainUI.getFrameWidth());
        int confirmPasswordY = (int) (0.55 * MainUI.getFrameHeight());
        confirmPasswordField.setBounds(confirmPasswordX, confirmPasswordY, inputFieldWidth, inputFieldHeight);
        confirmPasswordField.setFont(new Font("Arial", Font.BOLD, textFieldSize));
        confirmPasswordField.setForeground(Color.GRAY);
        confirmPasswordField.setEchoChar((char) 0); // Initially no dots
        confirmPasswordField.addFocusListener(passwordPlaceholderListener);
        add(confirmPasswordField);

        // Sign-Up Button
        JButton signUpButton = new JButton("Sign-Up");
        int signUpButtonX = (int) (0.525 * MainUI.getFrameWidth());
        int signUpButtonY = (int) (0.65 * MainUI.getFrameHeight());
        signUpButton.setBounds(signUpButtonX, signUpButtonY, buttonWidth, buttonHeight);
        signUpButton.setFont(new Font("Arial", Font.BOLD, textSize));
        add(signUpButton);

        // Home Page Redirect Button
        JButton homeButton = new JButton("Return Home");
        int homeButtonX = (int) (0.375 * MainUI.getFrameWidth());
        int homeButtonY = (int) (0.80 * MainUI.getFrameHeight());
        homeButton.setBounds(homeButtonX, homeButtonY, buttonWidth, buttonHeight);
        homeButton.setFont(new Font("Arial", Font.BOLD, textSize));
        add(homeButton);

        // Action listeners for buttons
        // Action listeners for buttons
        loginButton.addActionListener(e -> {
            String email = loginUsernameField.getText();
            String password = new String(loginPasswordField.getPassword());

            if (MainUI.dataBase.checkRegisteredUserExists(email)) {
                if (MainUI.dataBase.verifyLoginCredentials(email, password)) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Password.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "User does not exist.");
            }
        });
        
        signUpButton.addActionListener(e -> {
            String name = signUpUsernameField.getText();
            String email = signUpNameField.getText();
            String password = new String(signUpPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String address = signUpAddressField.getText(); // New field for address
            LocalDate registrationDate = LocalDate.now(); // Automatically set to the current date

            if (password.equals(confirmPassword)) {
                if (!MainUI.dataBase.checkUserExists(email)) {
                    // Insert user into the database
                    boolean success = MainUI.dataBase.insertNewRegisteredUser(name, email, password, address, registrationDate);
                    if (success) {
                        JOptionPane.showMessageDialog(this, "Sign-Up Successful!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Sign-Up Failed! Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Email already exists.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            }
        });

        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
    }
}
