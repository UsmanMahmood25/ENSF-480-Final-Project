
import java.time.*;

class DateTime {
    private String day;
    private String month;
    private String year;

    public DateTime() {
        LocalDate currentDate = LocalDate.now();
        this.day = String.valueOf(currentDate.getDayOfMonth());
        this.month = String.valueOf(currentDate.getMonthValue());
        this.year = String.valueOf(currentDate.getYear());
    }

    public String getDay() {
        return day;
    }
    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }
}

class Payment {
    
    private int PaymentID;
    private static int payIdValue = 1;
    private double Amount;
    private DateTime PaymentDate;

    public Payment(double Amount) {
        this.PaymentID = payIdValue++;
        this.Amount = Amount;
        this.PaymentDate = new DateTime(); // The object DateTime is "ctored" here
    }

    public int getPaymentID() {
        return PaymentID;
    }
    public double getAmount() {
        return Amount;
    }
    public DateTime getPaymentDate() {
        return PaymentDate;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
}

class Recepit {

    private String ReceiptID;
    private Ticket TicketID;
    private String DateIssued;
    private Payment PaymentMethod;
    private String ShowDetails;

    

}

class Ticket {

}
