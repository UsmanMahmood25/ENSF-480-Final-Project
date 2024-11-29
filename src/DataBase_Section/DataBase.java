package DataBase_Section;

import java.sql.*;

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
