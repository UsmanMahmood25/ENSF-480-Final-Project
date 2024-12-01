package DataBase_Section;

import java.util.Scanner;

public class ManagerAccess {
   
    // Located Here for the Manager to manipulate the DB (As well as check for sales)
    // Observed in the Terminal

    private static String username = "bob";
    private static String password = "password";
       
    public static void main(String []args) {

        // Setting up a general scanner
        Scanner text = new Scanner("Usernamne: ");

        System.out.println("");
        System.out.println("--- Hello Theater Manager ---");
        System.out.println("");

        System.out.println("Please Enter the Username and Password to Continue:");
        System.out.print("Enter Username: ");
        String userInput = text.nextLine();
        System.out.print("Enter Password: ");
        String passInput = text.nextLine();

        if ((username.equals(userInput)) && (password.equals(passInput))) {
            M_Access();
        } else {
            System.out.println("Incorrect Username or Password. Terminating the Program.");
            text.close();
            System.exit(1);
        }

        System.exit(1);
    }

    public static void M_Access() {
        boolean condition = true;
        while (condition) {

        }
    }
}

// For DB connection set up:
//      javac -cp lib/mysql-connector-j-9.1.0.jar -d bin src/UI_Components/*.java src/DataBase_Section/*.java src/Data_Components/*.java


// To run the program:
//      java -cp bin;lib/mysql-connector-j-9.1.0.jar DataBase_Section.ManagerAccess
// Or this:
//      java -cp "bin;lib/mysql-connector-j-9.1.0.jar" DataBase_Section.ManagerAccess

