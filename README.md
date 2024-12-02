# ENSF-480-Final-Project

The program can be run alongside a database connection with username "root" and password "root".
Alternatively, if a database is set up on your system with an alternative password, 
the file DataBase.java can be edited (at line 26) to hold the password you would prefer to use.

Once the database is set up, be sure to run the .sql dump file through the MySQL shell, or use
another method of your preference to initialize the database.

The program can then be compiled with the following line:

javac -cp lib/mysql-connector-j-9.1.0.jar -d bin src/UI_Components/*.java src/DataBase_Section/*.java src/Data_Components/*.java

And run with the following line:

For MainUI:
java -cp "bin;lib/mysql-connector-j-9.1.0.jar" UI_Components.MainUI

For ManagerAccess:
java -cp "bin;lib/mysql-connector-j-9.1.0.jar" DataBase_Section.ManagerAccess

For Financial Institution
java -cp "bin;lib/mysql-connector-j-9.1.0.jar" DataBase_Section.FinancialInst

If you encounter any difficulties running this software, please reach out to any or all of our
team members at our university email addresses, as we would be happy to provide support.

Thank you for your time and have a great winter break!
