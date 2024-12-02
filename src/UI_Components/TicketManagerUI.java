package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketManagerUI extends JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public TicketManagerUI(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Header
        JLabel headerLabel = new JLabel("Ticket Manager", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(headerLabel, BorderLayout.NORTH);

        // Center content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));
        
        JButton manageTicketsButton = new JButton("Manage Tickets");
        JButton backButton = new JButton("Back to Home");

        centerPanel.add(manageTicketsButton);
        centerPanel.add(backButton);

        add(centerPanel, BorderLayout.CENTER);

        // Button listeners
        manageTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TicketManagerUI.this, "Managing tickets...");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });
    }
}
