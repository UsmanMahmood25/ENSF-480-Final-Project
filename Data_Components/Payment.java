package Data_Components;
import java.util.Date;

public class Payment {
    private final User USER;
    private final Date DATE;
    private final float AMOUNT;

    public Payment(User USER, Date DATE, float AMOUNT) {
        this.USER = USER;
        this.DATE = DATE;
        this.AMOUNT = AMOUNT;
    }

    public User getUser() { return this.USER; }
    public Date getDate() { return this.DATE; }
    public float getAmount() { return this.AMOUNT; }

}
