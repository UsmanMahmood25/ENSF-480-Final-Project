package DataBase_Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Data_Components.*;

public class UserController {
    
    private Connection DB_Connection;
    private ResultSet DB_Results;

    public UserController(Connection DB_Connection) {
        this.DB_Connection = DB_Connection;
    }

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

    public boolean verifyUserLoginCredentials(String email, String password) {
        String query = "SELECT email FROM Users WHERE email = ? AND u_password = ?";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            DB_Results = preparedStatement.executeQuery();
            return DB_Results.next(); // If a record is found, credentials are valid.
        } catch (SQLException e) {
            System.out.println("Error verifying user login credentials");
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyRULoginCredentials(String email, String password) {
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

    public User getUserInfo(String email) {
        String query = "SELECT email, credit_card_number, cvc, expiry_date FROM Users WHERE email = ?";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve details
                String creditCardNumber = resultSet.getString("credit_card_number");
                String CVC = resultSet.getString("cvc");
                String expiryDate = resultSet.getString("expiry_date");

                // Return a User object (or similar data object for standard users)
                return new User(email, creditCardNumber, CVC, expiryDate);
            } else {
                System.out.println("No user found with the email: " + email);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user information (Standard User).");
            e.printStackTrace();
            return null;
        }
    }

    public RegisteredUser getRegisteredUserInfo(String email) {
        String query = "SELECT U.email, U.u_password, U.credit_card_number, U.cvc, U.expiry_date, " +
            "RU.ru_name, RU.ru_address, RU.date_of_registration " +
            "FROM Users U INNER JOIN RegisteredUsers RU ON U.email = RU.email WHERE U.email = ?";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve details
                String creditCardNumber = resultSet.getString("credit_card_number");
                String CVC = resultSet.getString("cvc");
                String expiryDate = resultSet.getString("expiry_date");
                String name = resultSet.getString("ru_name");
                String address = resultSet.getString("ru_address");
                Date registrationDate = resultSet.getDate("date_of_registration");

                // Return a RegisteredUser object
                return new RegisteredUser(email, creditCardNumber, CVC, expiryDate, registrationDate, name, address);
            } else {
                System.out.println("No registered user found with the email: " + email);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving registered user information (Registered User).");
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertNewUser(String email, String password, String creditCardNumber, String CVC, String expiryDate) {
        String query = "INSERT INTO Users (email, u_password, credit_card_number, cvc, expiry_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = DB_Connection.prepareStatement(query)) {
            // Set the parameters for the PreparedStatement
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, creditCardNumber);
            preparedStatement.setString(3, CVC);
            preparedStatement.setString(3, expiryDate);
    
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

    public boolean insertNewRegisteredUser(String name, String email, String password, String address, String creditCardNumber, String CVC, String expiryDate, Date registrationDate) {
        String insertUserQuery = "INSERT INTO Users (email, u_password, credit_card_number, cvc, expiry_date) VALUES (?, ?, ?, ?, ?)";
        String insertRegisteredUserQuery = "INSERT INTO RegisteredUsers (email, ru_name, ru_address, date_of_registration) VALUES (?, ?, ?, ?)";

        try (
            PreparedStatement insertUserStmt = DB_Connection.prepareStatement(insertUserQuery);
            PreparedStatement insertRegisteredUserStmt = DB_Connection.prepareStatement(insertRegisteredUserQuery)
        ) {
            // Insert into Users table
            insertUserStmt.setString(1, email);
            insertUserStmt.setString(2, password);
            insertUserStmt.setString(3, creditCardNumber);
            insertUserStmt.setString(4, CVC);
            insertUserStmt.setString(5, expiryDate);
            int userRowsAffected = insertUserStmt.executeUpdate();

            if (userRowsAffected == 0) {
                System.out.println("Failed to insert into Users table.");
                return false;
            }

            // Insert into RegisteredUsers table
            insertRegisteredUserStmt.setString(1, email);
            insertRegisteredUserStmt.setString(2, name);
            insertRegisteredUserStmt.setString(3, address);
            insertRegisteredUserStmt.setDate(4, new java.sql.Date(registrationDate.getTime()));;
            int registeredUserRowsAffected = insertRegisteredUserStmt.executeUpdate();

            return registeredUserRowsAffected > 0; // Success if both inserts succeed
        } catch (SQLException e) {
            System.out.println("Error inserting new registered user.");
            e.printStackTrace();
            return false;
        }
    }

}
