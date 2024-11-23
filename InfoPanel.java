import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    public InfoPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new BorderLayout());

        // Add a label
        JLabel label = new JLabel("This is the Info Screen", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        // Add a button to go back to the Home screen
        JButton backButton = new JButton("Back to Home");
        add(backButton, BorderLayout.SOUTH);

        // Add action listener to back button
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
    }
}
