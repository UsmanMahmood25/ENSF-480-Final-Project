package Data_Components;
import java.util.Date;

public class RegisteredUser extends User {
    
    private final Date DATE_OF_REGISTRATION; // which really means date of payment due
    private String name;
    private String address;

    public RegisteredUser(String email, String creditCardNumber, String CVC, Date expiryDate, Date DATE_OF_REGISTRATION, String name, String address) {
        super(email, creditCardNumber, CVC, expiryDate);
        this.DATE_OF_REGISTRATION = DATE_OF_REGISTRATION;
        this.name = name;
        this.address = address;
    }

    public Date getDateOfRegistration() { return this.DATE_OF_REGISTRATION; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return this.address; }
    public void setAddress(String address) { this.address = address; }

}
