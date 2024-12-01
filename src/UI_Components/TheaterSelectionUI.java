package UI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import DataBase_Section.*;
import Data_Components.*;

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

        ArrayList<String> theaters = DB_Connection.getTheatres();
        String[] theaterArray = theaters.toArray(new String[0]);

        theaterDropdown = new JComboBox<>(theaterArray);
        theaterDropdown.addActionListener(this::onTheaterSelected);

        movieDropdown = new JComboBox<>(new String[]{"Select Movie"});
        movieDropdown.setVisible(false);
        movieDropdown.addActionListener(this::onMovieSelected);

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
        
        // Use a HashSet to ensure uniqueness of movie names
        Set<String> uniqueMovies = new HashSet<>();
        ArrayList<Movie> movies = DB_Connection.getMoviesForTheater(selectedTheater);
        String[] movieArray = new String[movies.size() + 1];
        movieArray[0] = "Select Movie";
        
        for (int i = 0; i < movies.size(); i++) {
            uniqueMovies.add(movies.get(i).getMovieName());
        }
        
        movieArray = uniqueMovies.toArray(new String[0]);
        
        movieDropdown.setModel(new JComboBox<>(movieArray).getModel());
        movieDropdown.setVisible(true);
    }

    private void onMovieSelected(ActionEvent e) {
        String selectedMovie = (String) movieDropdown.getSelectedItem();
        
        ArrayList<Date> showDates = DB_Connection.getShowDatesForMovie(selectedMovie);
        String[] dateArray = new String[showDates.size() + 1];
        dateArray[0] = "Select Date";

        for (int i = 0; i < showDates.size(); i++) {
            dateArray[i + 1] = showDates.get(i).toString();
        }

        dateDropdown.setModel(new JComboBox<>(dateArray).getModel());
        dateDropdown.setVisible(true);
    }

    private void onDateSelected(ActionEvent e) {
        String selectedDate = (String) dateDropdown.getSelectedItem();
        
        ArrayList<String> showtimes = DB_Connection.getShowtimesForDate(selectedDate);

        timePanel.removeAll();

        for (String time : showtimes) {
            JButton timeButton = new JButton(time);
            timeButton.addActionListener(this::onTimeSelected);
            timePanel.add(timeButton);
        }
        
        revalidate();
        repaint();
    }
    
    private void onTimeSelected(ActionEvent e) {
        cardLayout.show(mainPanel, "Seats");
    }

    
}
