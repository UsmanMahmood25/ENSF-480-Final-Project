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

public class TheaterSelectionUI extends JPanel {
    private JComboBox<String> theaterDropdown;
    private JComboBox<String> movieDropdown;
    private JComboBox<String> dateDropdown;
    private JPanel timePanel;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JButton backButton;

    public TheaterSelectionUI(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        ArrayList<Movie> ml = new ArrayList<Movie>();
        ml.add(new Movie("m1", "horror",123.5, "scary"));
        ml.add(new Movie("m2", "comedy", 105.64, "funny"));

        ArrayList<Screen> sl = new ArrayList<Screen>();
        sl.add(new Screen("screen 1 - 3x3", 3, 3));
        sl.add(new Screen("screen 2 - 5x6", 5, 6));

        Theatre theatre = new Theatre("theatre 1", "123 abc st", ml, sl);
        Date d = new Date();
        Showtime showtime = new Showtime(theatre.getMovieList().get(0), theatre, theatre.getScreens().get(0), d, d, 10.15);
        
        theaterDropdown = new JComboBox<>(new String[]{"Select Theater", theatre.getTheatreName()});
        theaterDropdown.addActionListener(this::onTheaterSelected);

        movieDropdown = new JComboBox<>(new String[]{"Select Movie", theatre.getMovieList().get(0).getMovieName(), theatre.getMovieList().get(1).getMovieName()});
        movieDropdown.setVisible(false);
        movieDropdown.addActionListener(this::onMovieSelected);

        dateDropdown = new JComboBox<>(new String[]{"Select Date", "Sample Date"});
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
        movieDropdown.setVisible(true);
    }

    private void onMovieSelected(ActionEvent e) {
        dateDropdown.setVisible(true);
    }

    private void onDateSelected(ActionEvent e) {
        timePanel.removeAll();
        for (int i = 10; i <= 22; i++) {
            JButton timeButton = new JButton(i + ":00");
            timeButton.addActionListener(this::onTimeSelected);
            timePanel.add(timeButton);
        }
        revalidate();
        repaint();
    }
    
    private void onTimeSelected(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.BLUE);
        cardLayout.show(mainPanel, "Seats");
    }
    

}
