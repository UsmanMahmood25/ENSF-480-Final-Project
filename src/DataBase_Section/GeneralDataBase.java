package DataBase_Section;

import java.sql.*;

public class GeneralDataBase {
    
    private Connection DB_Connection;
    private ResultSet DB_Results;

    // Ctor for DataBase class
    public GeneralDataBase() {}

    // Getter for Connection
    public Connection getConnection() {
        return DB_Connection;
    }

    // Creating Connection to the MySQL DataBase
    public void createConnection() {
        String url = "jdbc:mysql://localhost:3306/project_db";
        String username = "root";
        String password = ""; // (REPLACE WITH YOUR MySQL PASSWORD)
        try {
            DB_Connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Data Base connection failed");
            e.printStackTrace();
        }
    }

    // Checking the User linked with Financial Institution (USED BY FinancialInst.java)
    public static void viewAllUsers(Connection conn) {
        String query = "SELECT email FROM Users";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- All Registered User Emails ---");
            while (rs.next()) {
                System.out.println("Email: " + rs.getString("email"));
            }
            System.out.println("----------------------------------");
        } catch (SQLException e) {
            System.out.println("Error retrieving user emails: " + e.getMessage());
        }
    }

    // Checking specific User's information (USED BY FinancialInst.java)
    public static void viewSpecificUser(Connection conn, String email) {
        String query = "SELECT credit_card_number, cvc, expiry_date FROM Users WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\n--- User Credit Card Details ---");
                    System.out.println("Credit Card Number: " + rs.getString("credit_card_number"));
                    System.out.println("CVC: " + rs.getString("cvc"));
                    System.out.println("Expiry Date: " + rs.getString("expiry_date"));
                    System.out.println("--------------------------------");
                } else {
                    System.out.println("No user found with email: " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user details: " + e.getMessage());
        }
    }

    // Method to insert a new movie into the database (USED BY ManagerAccess.java)
    public static void insertMovie(Connection conn, int movieId, String movieName, String genre, int duration, String description) {
        String query = "INSERT INTO Movies (movie_id, m_name, genre, duration, short_description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, movieId);
            pstmt.setString(2, movieName);
            pstmt.setString(3, genre);
            pstmt.setInt(4, duration);
            pstmt.setString(5, description);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Movie inserted successfully!");
            } else {
                System.out.println("Failed to insert movie.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting movie: " + e.getMessage());
        }
    }
    
    // Method to view all movies in the database (USED BY ManagerAccess.java)
    public static void viewAllMovies(Connection conn) {
        String query = "SELECT * FROM Movies";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- All Movies in Database ---");
            while (rs.next()) {
                System.out.println("Movie ID: " + rs.getInt("movie_id"));
                System.out.println("Movie Name: " + rs.getString("m_name"));
                System.out.println("Genre: " + rs.getString("genre"));
                System.out.println("Duration: " + rs.getInt("duration") + " minutes");
                System.out.println("Description: " + rs.getString("short_description"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving movies: " + e.getMessage());
        }
    }

    // Closing the Data Base when program finished
    public void closeConnection() {
        try {  
            if (DB_Results != null) {
                DB_Results.close();
                System.out.println("DB_Results Connection Closed");
            }
            if (DB_Connection != null) {
                DB_Connection.close();
                System.out.println("DB_Connection Connection Closed");
            }
            System.out.println("All Connections Closed");
        } catch (SQLException e) {
            System.out.println("An Error Occured: Unable to close Data Base");
            e.printStackTrace();
        }
    }
}
