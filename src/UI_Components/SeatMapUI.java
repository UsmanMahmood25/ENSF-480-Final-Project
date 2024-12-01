package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SeatMapUI extends JPanel {
    private final int ROWS = 5, COLUMNS = 8;
    private Set<JButton> selectedSeats = new HashSet<>();
    private Set<JButton> unavailableSeats = new HashSet<>();
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JLabel headingLabel;

    public SeatMapUI(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        headingLabel = new JLabel("Select Your Seats", JLabel.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headingLabel, BorderLayout.NORTH);

        JPanel seatGrid = new JPanel(new GridLayout(ROWS, COLUMNS, 5, 5));
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                JButton seatButton = new JButton(getSeatLabel(i, j));
                seatButton.addActionListener(e -> toggleSeatSelection(seatButton));
                seatButton.setEnabled(true);

                if (Math.random() < 0.2) {
                    seatButton.setEnabled(false);
                    seatButton.setBackground(Color.GRAY);
                    unavailableSeats.add(seatButton);
                }

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
        if (unavailableSeats.contains(button)) {
            return;
        }

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

    public void updateHeading(String theater, String movie, String screen, String date, String time) {
        String headingText = String.format("%s - %s - %s - %s - %s", theater, movie, screen, date, time);
        headingLabel.setText(headingText);
    }

    private String getSeatLabel(int row, int column) {
        char rowLabel = (char) ('A' + row);
        int seatNumber = column + 1;
        return rowLabel + Integer.toString(seatNumber);
    }
}
