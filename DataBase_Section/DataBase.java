package DataBase_Section;

import java.sql.*;

public class DataBase {
    
    private Connection DB_Connection;
    private ResultSet DB_Results;

    // Ctor for DataBase class
    public DataBase() {}

    // Creating Connection to the MySQL DataBase
    public void createConnection() {
        try {
            DB_Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT_DB", "root", "Gabber793$");
        } catch (SQLException e) {
            System.out.println("An Error Occured: Unable to connect to Data Base");
            e.printStackTrace();
        }
    }

    // Closing the Data Base when program finished
    public void closeDB() {
        try {  
            if (DB_Results != null) {
                DB_Results.close();
            }
            if (DB_Connection != null) {
                DB_Connection.close();
            }
        } catch (SQLException e) {
            System.out.println("An Error Occured: Unable to close Data Base");
            e.printStackTrace();
        }
    }
}
