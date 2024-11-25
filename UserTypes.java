
class User {

    private String name;
    private int UserID;
    private static int IdValue = 20;
    private String email;
    private Payment PaymentInfo;
    private boolean isRegistered;

    public User(String name, int UserID, String email) {
        this.name = name;
        this.UserID = IdValue++;
        this.email = email;
    }
    public User() {}

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getUserID() {
        return UserID;
    }
    
}

class Registered_User extends User {

    private float MembershipFee;
    private String RegistrationDate;
    private String ExpirationDate;
    private boolean isAdminFeeExempt;
    private int ReservedSeatCount;
    private boolean newsBeforePublic;
}

class Manager {

}


// Theatre, movie, seats
// payments, recepits, ticket (datetime)
