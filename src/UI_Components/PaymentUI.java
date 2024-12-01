package UI_Components;

import javax.swing.*;

import Data_Components.RegisteredUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentUI extends JPanel {

    public PaymentUI(CardLayout cardLayout, JPanel mainPanel, RegisteredUser currentRegisteredUser) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Add a title label
        JLabel titleLabel = new JLabel("Enter Payment Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);

        // Add credit card number label and text field
        JLabel cardNumberLabel = new JLabel("Credit Card Number:");
        gbc.gridy = 1;
        add(cardNumberLabel, gbc);
        
        JTextField cardNumberField = new JTextField(20);
        gbc.gridy = 2;
        add(cardNumberField, gbc);

        // Add CVC label and text field
        JLabel cvcLabel = new JLabel("CVC:");
        gbc.gridy = 3;
        add(cvcLabel, gbc);
        
        JTextField cvcField = new JTextField(4);
        gbc.gridy = 4;
        add(cvcField, gbc);

        JLabel expiryLabel = new JLabel("Expiry Date (MM/YY):");
        gbc.gridy = 5;
        add(expiryLabel, gbc);
        
        JTextField expiryField = new JTextField(5);
        gbc.gridy = 6;
        add(expiryField, gbc);

        boolean isUserSignedIn = currentRegisteredUser != null ? true : false;
        if (isUserSignedIn) {
            JOptionPane.showMessageDialog(PaymentUI.this, "Payment processed automatically through account!");
            cardLayout.show(mainPanel, "Home");
        }

        JButton paymentButton = new JButton("Process Payment");
        gbc.gridy = 7;
        add(paymentButton, gbc);

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isUserSignedIn) {
                    // do nothing
                    
                } else {
                    String cardNumber = cardNumberField.getText().trim();
                    String cvc = cvcField.getText().trim();
                    String expiry = expiryField.getText().trim();

                    if (cardNumber.isEmpty() || cvc.isEmpty() || expiry.isEmpty()) {
                        JOptionPane.showMessageDialog(PaymentUI.this, "Please fill in all fields.");
                    } else if (validateCreditCard(cardNumber, cvc, expiry)) {
                        JOptionPane.showMessageDialog(PaymentUI.this, "Payment processed!");
                        cardLayout.show(mainPanel, "MainScreen");
                    } else {
                        JOptionPane.showMessageDialog(PaymentUI.this, "Invalid credit card details.");
                    }
                }
            }
        });

        // Add a button to go back to the previous screen
        JButton backButton = new JButton("Back");
        gbc.gridy = 8;
        add(backButton, gbc);

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Seats"));
    }

    private boolean validateCreditCard(String cardNumber, String cvc, String expiry) {
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return false;
        }
        if (cvc.length() != 3 || !cvc.matches("\\d+")) {
            return false;
        }
        if (!expiry.matches("\\d{2}/\\d{2}")) {
            return false;
        }
        return true;
    }
}
