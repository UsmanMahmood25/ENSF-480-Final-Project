package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SeatMapUI extends JPanel {
    private final int ROWS = 5, COLUMNS = 8;
    private Set<JButton> selectedSeats = new HashSet<>();
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SeatMapUI(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Title label for the seat map screen
        JLabel movieLabel = new JLabel("Now Showing: Movie Title", JLabel.CENTER);
        movieLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(movieLabel, BorderLayout.NORTH);

        JPanel seatGrid = new JPanel(new GridLayout(ROWS, COLUMNS, 5, 5));
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                JButton seatButton = new JButton("Seat " + (i * COLUMNS + j + 1));
                seatButton.addActionListener(e -> toggleSeatSelection(seatButton));
                seatGrid.add(seatButton);
            }
        }
        add(seatGrid, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Theater"));

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> onContinue());

        bottomPanel.add(backButton);
        bottomPanel.add(continueButton);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void toggleSeatSelection(JButton button) {
        if (selectedSeats.contains(button)) {
            button.setBackground(null);
            selectedSeats.remove(button);
        } else {
            button.setBackground(Color.BLUE);
            selectedSeats.add(button);
        }
    }

    private void onContinue() {
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one seat to continue.");
        } else {
            cardLayout.show(mainPanel, "Payment");
        }
    }
}
