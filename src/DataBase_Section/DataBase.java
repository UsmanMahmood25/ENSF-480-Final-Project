package DataBase_Section;

import java.sql.*;
import java.time.LocalDate;

public class DataBase {
    
    private Connection DB_Connection;
    private ResultSet DB_Results;

    // Ctor for DataBase class
    public DataBase() {}

    // Creating Connection to the MySQL DataBase
    public void createConnection() {
        String url = "jdbc:mysql://localhost:3306/project_db";
        String username = "root";
        String password = "Gabber793$";
        try {
            DB_Connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Data Base connection failed");
            e.printStackTrace();
        }
    }

    // Checks if the User (Standard) exists
    public boolean checkUserExists(String email) {
        String query = "SELECT email FROM Users WHERE email = ?";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            DB_Results = preparedStatement.executeQuery();
            return DB_Results.next(); // If a record is found, return true.
        } catch (SQLException e) {
            System.out.println("Error checking if user exists");
            e.printStackTrace();
            return false;
        }
    }

    // Checks if the User (Registered) exists
    public boolean checkRegisteredUserExists(String email) {
        String query = "SELECT email FROM RegisteredUsers WHERE email = ?";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            DB_Results = preparedStatement.executeQuery();
            return DB_Results.next(); // If a record is found, return true.
        } catch (SQLException e) {
            System.out.println("Error checking if registered user exists");
            e.printStackTrace();
            return false;
        }
    }

    // Checking if the Login Details are valid
    public boolean verifyLoginCredentials(String email, String password) {
        String query = "SELECT RU.email FROM RegisteredUsers RU INNER JOIN Users U ON RU.email = U.email WHERE U.email = ? AND U.u_password = ?";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            DB_Results = preparedStatement.executeQuery();
            return DB_Results.next(); // If a record is found, credentials are valid.
        } catch (SQLException e) {
            System.out.println("Error verifying login credentials");
            e.printStackTrace();
            return false;
        }
    }

    // Inserting a new User (Standard) into the Data Base
    public boolean insertNewUser(String name, String email, String password) {
        String query = "INSERT INTO Users (email, u_password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            // Set the parameters for the PreparedStatement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
    
            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
            
            // If rowsAffected is greater than 0, the insert was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting new user");
            e.printStackTrace();
            return false;  // Return false if the insertion failed
        }
    }

    // Inserting a new User (Registered) into the Data Base 
    public boolean insertNewRegisteredUser(String name, String email, String password, String address, String creditCardNumber, String CVC, String expiryDate, LocalDate registrationDate) {
        String insertUserQuery = "INSERT INTO Users (email, u_password, credit_card_number, cvc, u_expiry_date) VALUES (?, ?, ?, ?, ?)";
        String insertRegisteredUserQuery = "INSERT INTO RegisteredUsers (email, ru_name, ru_address, date_of_registration) VALUES (?, ?, ?, ?)";

        try (
            PreparedStatement insertUserStmt = DB_Connection.prepareStatement(insertUserQuery);
            PreparedStatement insertRegisteredUserStmt = DB_Connection.prepareStatement(insertRegisteredUserQuery)
        ) {
            // Insert into Users table
            insertUserStmt.setString(1, email);
            insertUserStmt.setString(2, password);
            int userRowsAffected = insertUserStmt.executeUpdate();

            if (userRowsAffected == 0) {
                System.out.println("Failed to insert into Users table.");
                return false;
            }

            // Insert into RegisteredUsers table
            insertRegisteredUserStmt.setString(1, email);
            insertRegisteredUserStmt.setString(2, name);
            insertRegisteredUserStmt.setString(3, address);
            insertRegisteredUserStmt.setDate(4, java.sql.Date.valueOf(registrationDate));
            int registeredUserRowsAffected = insertRegisteredUserStmt.executeUpdate();

            return registeredUserRowsAffected > 0; // Success if both inserts succeed
        } catch (SQLException e) {
            System.out.println("Error inserting new registered user.");
            e.printStackTrace();
            return false;
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
