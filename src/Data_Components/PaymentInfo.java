package Data_Components;
import java.util.Date;

public class PaymentInfo {
    private final String CREDIT_CARD_NUMBER;
    private final String CVC;
    private final String EXPIRY_DATE;

    public PaymentInfo(String CREDIT_CARD_NUMBER, String CVC, String EXPIRY_DATE) {
        this.CREDIT_CARD_NUMBER = CREDIT_CARD_NUMBER;
        this.CVC = CVC;
        this.EXPIRY_DATE = EXPIRY_DATE;
    }

    public String getCreditCardNumber() { return this.CREDIT_CARD_NUMBER; }
    public String getCVC() { return this.CVC; }
    public String getExpiryDate() { return this.EXPIRY_DATE; }

}
