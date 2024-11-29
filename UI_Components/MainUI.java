package UI_Components;

import javax.swing.*;
import java.awt.*;

public class MainUI {

    public static void main(String [] args) {
        // Set-up screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set JFrame dimensions as a percentage of screen size
        int frameWidth = (int) (screenWidth * 0.8); // 80% of screen width
        int frameHeight = (int) (screenHeight * 0.8); // 80% of screen height

        // Creating the primary JFrame
        JFrame frame = new JFrame("AcmePlex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocationRelativeTo(null); // Centering the frame
        frame.setResizable(false);

        // Creating a Master CardLayout to switch between panels
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Creating the sub-level panels (instances of panels)
        HomeUI homePanel = new HomeUI(cardLayout, mainPanel);
        SignUp_LoginUI signup_loginPanel = new SignUp_LoginUI(cardLayout, mainPanel);
        MovieSelectUI moviePanel = new MovieSelectUI(cardLayout, mainPanel);
        PaymentUI paymentPanel = new PaymentUI(cardLayout, mainPanel);
        SeatMapUI seatPanel = new SeatMapUI(cardLayout, mainPanel);
        TheaterUI theaterPanel = new TheaterUI(cardLayout, mainPanel);
        TicketBookingUI bookingPanel = new TicketBookingUI(cardLayout, mainPanel);

        // Adding the sub-level panels to the main panel
            // The first sub-level panel will first appear when application is run
        mainPanel.add(homePanel, "Home");
            // The other sub-level panels will appear in any order (dependent on the redirection of other UI's)
        mainPanel.add(signup_loginPanel, "Sign-Up/Login");
        mainPanel.add(moviePanel, "Movies");
        mainPanel.add(paymentPanel, "Payment");
        mainPanel.add(seatPanel, "Seats");
        mainPanel.add(theaterPanel, "Theater");
        mainPanel.add(bookingPanel, "Booking");

        // Adding the primary panel to the frame
        frame.add(mainPanel);

        // Making the frame visible
        frame.setVisible(true);

    }
}

// The main frame of the UI