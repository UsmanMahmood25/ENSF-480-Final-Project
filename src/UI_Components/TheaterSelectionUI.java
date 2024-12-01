package UI_Components;

import javax.swing.*;

import Data_Components.Movie;
import Data_Components.Screen;
import Data_Components.Showtime;
import Data_Components.Theatre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import DataBase_Section.*;

public class TheaterSelectionUI extends JPanel {
    private JComboBox<String> theaterDropdown;
    private JComboBox<String> movieDropdown;
    private JComboBox<String> dateDropdown;
    private JPanel timePanel;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton backButton;
    private DataBase DB_Connection = MainUI.dataBase;

    public TheaterSelectionUI(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        // Get the list of theaters from the database
        ArrayList<String> theaters = DB_Connection.getTheatres();
        String[] theaterArray = theaters.toArray(new String[0]);

        // Initialize the theater dropdown with real data
        theaterDropdown = new JComboBox<>(theaterArray);
        theaterDropdown.addActionListener(this::onTheaterSelected);

        // Initialize the movie dropdown (initially hidden)
        movieDropdown = new JComboBox<>(new String[]{"Select Movie"});
        movieDropdown.setVisible(false);
        movieDropdown.addActionListener(this::onMovieSelected);

        // Initialize the date dropdown (initially hidden)
        dateDropdown = new JComboBox<>(new String[]{"Select Date"});
        dateDropdown.setVisible(false);
        dateDropdown.addActionListener(this::onDateSelected);

        timePanel = new JPanel(new FlowLayout());

        backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(theaterDropdown)
                .addComponent(movieDropdown)
                .addComponent(dateDropdown)
                .addComponent(timePanel)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(backButton))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(theaterDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(movieDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(dateDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(timePanel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton))
        );
    }

    private void onTheaterSelected(ActionEvent e) {
        String selectedTheater = (String) theaterDropdown.getSelectedItem();
        
        
        // Get the list of movies for the selected theater from the database
        ArrayList<Movie> movies = DB_Connection.getMoviesForTheater(selectedTheater);
        String[] movieArray = new String[movies.size() + 1];
        movieArray[0] = "Select Movie"; // Default option
        
        for (int i = 0; i < movies.size(); i++) {
            movieArray[i + 1] = movies.get(i).getMovieName();
        }

        // Populate movie dropdown with the movies for the selected theater
        movieDropdown.setModel(new JComboBox<>(movieArray).getModel());
        movieDropdown.setVisible(true);
    }

    private void onMovieSelected(ActionEvent e) {
        String selectedMovie = (String) movieDropdown.getSelectedItem();
        
        // Get the list of dates (showtimes) for the selected movie from the database
        ArrayList<Date> showDates = DB_Connection.getShowDatesForMovie(selectedMovie);
        String[] dateArray = new String[showDates.size() + 1];
        dateArray[0] = "Select Date"; // Default option

        for (int i = 0; i < showDates.size(); i++) {
            dateArray[i + 1] = showDates.get(i).toString(); // Convert Date to String for display
        }

        // Populate the date dropdown with the available show dates for the selected movie
        dateDropdown.setModel(new JComboBox<>(dateArray).getModel());
        dateDropdown.setVisible(true);
    }

    private void onDateSelected(ActionEvent e) {
        String selectedDate = (String) dateDropdown.getSelectedItem();
        
        // Get the available showtimes for the selected date
        ArrayList<String> showtimes = DB_Connection.getShowtimesForDate(selectedDate);

        // Remove previous time buttons
        timePanel.removeAll();

        // Add buttons for each available showtime
        for (String time : showtimes) {
            JButton timeButton = new JButton(time);
            timeButton.addActionListener(this::onTimeSelected);
            timePanel.add(timeButton);
        }
        
        // Revalidate and repaint the panel
        revalidate();
        repaint();
    }
    
    private void onTimeSelected(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.BLUE);
        cardLayout.show(mainPanel, "Seats");
    }
}
