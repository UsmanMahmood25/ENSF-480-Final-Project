
class User {

    private String name;
    private int UserID;
    private String email;
    private Payment PaymentInfo;
    private boolean isRegistered;

    public User(String name, int UserID, String email) {
        this.name = name;
        this.UserID = UserID;
        this.email = email;
    }

    public User() {}

    public void destroy() {}

    public void setName(String name) {
        this.name = name;
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
