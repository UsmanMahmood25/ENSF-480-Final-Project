package Data_Components;

public class Ticket {
    private String email;
    private int showtimeId;
    private int seatRow;
    private int seatCol;
    private double ticketPrice;

    public Ticket(String email, int showtimeId, int seatRow, int seatCol, double ticketPrice) {
        this.email = email;
        this.showtimeId = showtimeId;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.ticketPrice = ticketPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(int seatCol) {
        this.seatCol = seatCol;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "email='" + email + '\'' +
                ", showtimeId=" + showtimeId +
                ", seatRow=" + seatRow +
                ", seatCol=" + seatCol +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
