import javax.swing.*;
import java.awt.*;

public class ResponsiveUI {

    public static void main(String[] args) {
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set JFrame dimensions as a percentage of screen size
        int frameWidth = (int) (screenWidth * 0.8); // 80% of screen width
        int frameHeight = (int) (screenHeight * 0.8); // 80% of screen height

        // Create the main JFrame
        JFrame frame = new JFrame("Responsive UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocationRelativeTo(null); // Center the frame

        // Create a CardLayout to switch between panels
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Create instances of panels
        HomePanel homePanel = new HomePanel(cardLayout, mainPanel);
        InfoPanel infoPanel = new InfoPanel(cardLayout, mainPanel);

        // Add panels to the main panel
        mainPanel.add(homePanel, "Home");
        mainPanel.add(infoPanel, "Info");

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}

// We can create a main UI that will switch between the various sub-pages
// The InfoPanel and HomePanel are examples. The order they appear in adding to main panel matters


