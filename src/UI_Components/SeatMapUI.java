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

        // Heading with Movie Name, Date, and Time
        JPanel headingPanel = new JPanel(new GridLayout(4, 1)); // 4 rows: movie, date, time, and screen
        JLabel movieTitleLabel = new JLabel("Movie Title: Avatar 2", JLabel.CENTER);
        JLabel movieDateLabel = new JLabel("Date: December 5, 2024", JLabel.CENTER);
        JLabel movieTimeLabel = new JLabel("Time: 7:30 PM", JLabel.CENTER);
        JLabel screenLabel = new JLabel("SCREEN", JLabel.CENTER);

        movieTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        movieDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        movieTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        screenLabel.setFont(new Font("Arial", Font.BOLD, 20));

        headingPanel.add(movieTitleLabel);
        headingPanel.add(movieDateLabel);
        headingPanel.add(movieTimeLabel);
        headingPanel.add(screenLabel);

        add(headingPanel, BorderLayout.NORTH);

        // Seat Map Grid
        JPanel seatGrid = new JPanel(new GridLayout(ROWS, COLUMNS, 5, 5));
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                JButton seatButton = new JButton(getSeatLabel(i, j));
                seatButton.addActionListener(e -> toggleSeatSelection(seatButton));
                seatGrid.add(seatButton);
            }
        }
        add(seatGrid, BorderLayout.CENTER);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "TheaterSelection"));

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> onContinue());

        bottomPanel.add(backButton);
        bottomPanel.add(continueButton);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private String getSeatLabel(int row, int col) {
        // Return seat labels in A1, B2, C3, etc. format
        char rowLabel = (char) ('A' + row);
        return rowLabel + Integer.toString(col + 1);
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
