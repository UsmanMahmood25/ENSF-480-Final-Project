package Data_Components;
import java.time.LocalDate;
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

// Code below functions as Real-Time date

// class DateTime {
//     private String day;
//     private String month;
//     private String year;

//     public DateTime() {
//         LocalDate currentDate = LocalDate.now();
//         this.day = String.valueOf(currentDate.getDayOfMonth());
//         this.month = String.valueOf(currentDate.getMonthValue());
//         this.year = String.valueOf(currentDate.getYear());
//     }

//     public String getDay() {
//         return day;
//     }
//     public String getMonth() {
//         return month;
//     }
//     public String getYear() {
//         return year;
//     }
// }
