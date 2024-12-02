package DataBase_Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Data_Components.*;

public class ShowtimeController {
    
    private Connection DB_Connection;
    private ResultSet DB_Results;

    public ShowtimeController(Connection DB_Connection) {
        this.DB_Connection = DB_Connection;
    }

    public ArrayList<Date> getShowDatesForMovie(String movieName) {
        ArrayList<Date> showDates = new ArrayList<>();
        String query = "SELECT DISTINCT DATE(s.showDate) AS show_date FROM Showtimes s " +
                    "JOIN Movies m ON s.movie = m.movie_id " +
                    "WHERE m.m_name = ?";

        try (PreparedStatement getShowDatesStmt = DB_Connection.prepareStatement(query)) {
            getShowDatesStmt.setString(1, movieName);  // Set the selected movie's name
            try (ResultSet rs = getShowDatesStmt.executeQuery()) {
                while (rs.next()) {
                    Date showDate = rs.getDate("show_date");  // Retrieve the show date as a Date object
                    showDates.add(showDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showDates;
    }

    public ArrayList<String> getShowtimesForDate(String date) {
        ArrayList<String> showtimes = new ArrayList<>();
        String query = "SELECT DISTINCT TIME(s.showDate) AS showtime FROM Showtimes s " +
                       "WHERE DATE(s.showDate) = ?";
    
        try (PreparedStatement getShowtimesStmt = DB_Connection.prepareStatement(query)) {
            getShowtimesStmt.setString(1, date);  // Set the date (e.g., '2024-11-30')
            try (ResultSet rs = getShowtimesStmt.executeQuery()) {
                while (rs.next()) {
                    showtimes.add(rs.getString("showtime"));  // Adding the time of the show
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showtimes;
    }

    public ArrayList<Movie> getMoviesForTheater(String theaterName) {
        ArrayList<Movie> movies = new ArrayList<>();
        String query = "SELECT m.movie_id, m.m_name, m.genre, m.duration, m.short_description " +
                       "FROM Movies m " +
                       "JOIN Showtimes s ON m.movie_id = s.movie " +
                       "JOIN Theater t ON s.theater = t.theater_id " +
                       "WHERE t.theater_name = ?";
    
        try (PreparedStatement getMoviesStmt = DB_Connection.prepareStatement(query)) {
            getMoviesStmt.setString(1, theaterName);
            try (ResultSet rs = getMoviesStmt.executeQuery()) {
                while (rs.next()) {
                    String movieName = rs.getString("m_name");
                    String genre = rs.getString("genre");
                    int duration = rs.getInt("duration");
                    String description = rs.getString("short_description");
    
                    // Assuming your Movie constructor takes (name, genre, duration, description)
                    Movie movie = new Movie(movieName, genre, duration, description);
                    movies.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<String> getTheatres() {
        ArrayList<String> theatres = new ArrayList<>();
        String query = "SELECT theater_name FROM Theater";
        try (
            PreparedStatement getTheatresStmt = DB_Connection.prepareStatement(query);
             ResultSet rs = getTheatresStmt.executeQuery()) {
            while (rs.next()) {
                theatres.add(rs.getString("theater_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theatres;
    }

    public ArrayList<Ticket> getTicketsByEmail(String email) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM tickets WHERE email = ?";
        try (PreparedStatement statement = DB_Connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                    resultSet.getString("email"),
                    resultSet.getInt("showtime_id"),
                    resultSet.getInt("seat_row"),
                    resultSet.getInt("seat_col"),
                    resultSet.getDouble("price")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Error inserting new registered user.");
            e.printStackTrace();
        }
        return tickets;
    }

    public boolean cancelTicket(int showtimeId, int seatRow, int seatCol) {
        String query = "DELETE FROM tickets WHERE showtime_id = ? AND seat_row = ? AND seat_col = ?";
        try (PreparedStatement statement = DB_Connection.prepareStatement(query)) {
            statement.setInt(1, showtimeId);
            statement.setInt(2, seatRow);
            statement.setInt(3, seatCol);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting new registered user.");
            e.printStackTrace();
        }
        return true;
    }

    private void addNewTicket(String email, java.sql.Date showtime, int row, int column, Seat[] selectedSeats) {
        String insertTicketsQuery = "INSERT INTO Tickets (email, showtime, row, column) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement insertTicketStmt = DB_Connection.prepareStatement(insertTicketsQuery);

            for (Seat seat : selectedSeats) {
                insertTicketStmt.setString(1, email);
                insertTicketStmt.setDate(2, showtime);
                insertTicketStmt.setInt(3, seat.getRow());
                insertTicketStmt.setInt(4, seat.getCol());
                insertTicketStmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Could not insert ticket.");
            e.printStackTrace();
        }
    }
}
