package DataBase_Section;

import java.util.Scanner;

public class FinancialInst {
   
    // Located Here for Financial Insitution to check the users Credit Card Details
    // Observed in the Terminal

    private static String username = "alex";
    private static String password = "password";
    public static final GeneralDataBase dataBase = new GeneralDataBase();
       
    public static void main(String []args) {

        // Establishing a connection with the Data Base
        dataBase.createConnection();

        // Setting up a general scanner
        Scanner text = new Scanner(System.in);

        System.out.println("");
        System.out.println("--- Hello Financial Institution ---");
        System.out.println("");

        System.out.println("Please Enter the Username and Password to Continue:");
        System.out.print("Enter Username: ");
        String userInput = text.nextLine();
        System.out.print("Enter Password: ");
        String passInput = text.nextLine();

        if ((username.equals(userInput)) && (password.equals(passInput))) {
            FI_Access();
        } else {
            System.out.println("Incorrect Username or Password. Terminating the Program.");
            text.close();
            dataBase.closeConnection();
            System.exit(1);
        }

        text.close();
        dataBase.closeConnection();
        System.exit(1);
    }

    public static void FI_Access() {
        boolean condition = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("--- Welcome Alex ---");
           
            while (condition) {
                System.out.println("\nWhat would you like to view:\n");
                System.out.println("1. Check all Users using this Financial Institution");
                System.out.println("2. Check a specific User's information");
                System.out.println("3. Exit the Program");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        GeneralDataBase.viewAllUsers(dataBase.getConnection());
                        break;
                    case 2:
                        System.out.print("Enter the email of the user: ");
                        String email = scanner.nextLine();
                        GeneralDataBase.viewSpecificUser(dataBase.getConnection(), email);
                        break;
                    case 3:
                        condition = false;
                        System.out.println("Exiting the program. Goodbye!\n");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        scanner.close();
    }
}

// For DB connection set up:
//      javac -cp lib/mysql-connector-j-9.1.0.jar -d bin src/UI_Components/*.java src/DataBase_Section/*.java src/Data_Components/*.java


// To run the program:
//      java -cp bin;lib/mysql-connector-j-9.1.0.jar DataBase_Section.FinancialInst
// Or this:
//      java -cp "bin;lib/mysql-connector-j-9.1.0.jar" DataBase_Section.FinancialInst
