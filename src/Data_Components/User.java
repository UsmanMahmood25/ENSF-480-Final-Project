package Data_Components;

public class User {
    protected String email;
    protected PaymentInfo paymentInfo;

    public User(String email, String creditCardNumber, String CVC, String expiryDate) {
        this.email = email;
        this.paymentInfo = new PaymentInfo(creditCardNumber, CVC, expiryDate);
    }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public /* lol */ PaymentInfo getPaymentInfo() { return this.paymentInfo; }
    public void setPaymentInfo(String creditCardNumber, String CVC, String expiryDate) {
        this.paymentInfo = new PaymentInfo(creditCardNumber, CVC, expiryDate);
    }
    
}
