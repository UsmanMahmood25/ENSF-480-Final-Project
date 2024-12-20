package DataBase_Section;

import java.sql.*;
// import java.util.ArrayList;
// import java.util.Date;

public class DB_ConnectionManager {
    
    private Connection DB_Connection;
    private ResultSet DB_Results;

    public DB_ConnectionManager() {}

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

    public Connection getConnection() {
        return DB_Connection;
    }

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
