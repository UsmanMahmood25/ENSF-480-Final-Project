package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import DataBase_Section.*;
import Data_Components.*;

public class MainUI {

    // Initializing the frame of UI
    public static int frameWidth;
    public static int frameHeight;

    // Initializing the dataBase
    // public static final DataBase dataBase = new DataBase();
    public static DB_ConnectionManager dbConnect = new DB_ConnectionManager();
    public static UserController userController;
    public static ShowtimeController showTimeController;

    // Intializing the Users (Standard and Registered)
    public static User currentUser = null;
    public static RegisteredUser currentRegisteredUser = null;

    public static void main(String [] args) {

        // Connecting to the DataBase
        // dataBase.createConnection();
        dbConnect.createConnection();
        Connection connValue = dbConnect.getConnection();
        userController = new UserController(connValue);
        showTimeController = new ShowtimeController(connValue);

        // Set-up screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set JFrame dimensions as a percentage of screen size
        frameWidth = (int) (screenWidth * 0.8); // 80% of screen width
        frameHeight = (int) (screenHeight * 0.9); // 90% of screen height

        // Creating the primary JFrame
        JFrame frame = new JFrame("AcmePlex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocationRelativeTo(null); // Centering the frame
        frame.setResizable(true);

        // Create the WindowListener to handle window closing event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Close the database connection when the window is closed
                dbConnect.closeConnection();
                System.exit(0); // Exit the application
            }
        });

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Creating the sub-level panels (instances of panels)
        HomeUI homePanel = new HomeUI(cardLayout, mainPanel);
        SignUp_LoginUI signup_loginPanel = new SignUp_LoginUI(cardLayout, mainPanel, userController);
        PaymentUI paymentPanel = new PaymentUI(cardLayout, mainPanel, currentRegisteredUser);
        SeatMapUI seatPanel = new SeatMapUI(cardLayout, mainPanel);
        TheaterSelectionUI theaterPanel = new TheaterSelectionUI(cardLayout, mainPanel, showTimeController);
        TicketBookingUI bookingPanel = new TicketBookingUI(cardLayout, mainPanel);
        TicketManagerUI ticketManagerPanel = new TicketManagerUI(cardLayout, mainPanel);


        // Adding the sub-level panels to the main panel
            // The first sub-level panel will first appear when application is run
        mainPanel.add(homePanel, "Home");
            // The other sub-level panels will appear in any order (dependent on the redirection of other UI's)
        mainPanel.add(signup_loginPanel, "Sign-Up/Login");
        mainPanel.add(paymentPanel, "Payment");
        mainPanel.add(seatPanel, "Seats");
        mainPanel.add(theaterPanel, "Theater");
        mainPanel.add(bookingPanel, "Booking");
        mainPanel.add(ticketManagerPanel, "TicketManager");

        // Adding the primary panel to the frame
        frame.add(mainPanel);

        // Making the frame visible
        frame.setVisible(true);
    }

    public static int getFrameWidth() {
        return frameWidth;
    }
    public static int getFrameHeight() {
        return frameHeight;
    }
}

// The main frame of the UI

// For DB connection set up:
//      javac -cp lib/mysql-connector-j-9.1.0.jar -d bin src/UI_Components/*.java src/DataBase_Section/*.java src/Data_Components/*.java

// To run the program:
//      java -cp bin;lib/mysql-connector-j-9.1.0.jar UI_Components.MainUI
// Or this:
//      java -cp "bin;lib/mysql-connector-j-9.1.0.jar" UI_Components.MainUI
