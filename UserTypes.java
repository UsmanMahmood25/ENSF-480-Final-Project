
class User {

    protected String name;
    protected int UserID;
    protected static int IdValue = 20;
    protected String email;
    protected Payment PaymentInfo;
    protected boolean isRegistered;
    protected boolean newsBeforePublic;
    protected boolean isAdminFeeExempt;

    public User(String name, String email) {
        this.name = name;
        this.UserID = IdValue++;
        this.email = email;
        this.isRegistered = false;
        this.newsBeforePublic = false;
        this.isAdminFeeExempt = false;
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

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPaymentInfo(Payment PaymentInfo) {
        this.PaymentInfo = PaymentInfo;
    }
    public Payment getPaymentInfo() {
        return PaymentInfo;
    }
    
}

class Registered_User extends User {

    private static double MembershipFee = 20;
    private String RegistrationDate;
    private String address;
    private String ExpirationDate;
    private int ReservedSeatCount;
    private Card creditCardInfo;

    public Registered_User(String name, String email, String address, Card creditCardInfo) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.creditCardInfo = creditCardInfo;
        this.UserID = IdValue++;
        this.isRegistered = true;
        this.newsBeforePublic = true;
        this.isAdminFeeExempt = true;
    }

}

class Card {

}

class Manager {

}


// Theatre, movie, seats
// payments, recepits, ticket (datetime)

// entity: user, movie, therate