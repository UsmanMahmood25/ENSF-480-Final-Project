package Data_Components;

public class Ticket {
    private User user;
    private int showtimeId;
    private int seatRow;
    private int seatCol;
    private double ticketPrice;

    public Ticket(User user, int showtimeId, int seatRow, int seatCol, double ticketPrice) {
        this.user = user;
        this.showtimeId = showtimeId;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.ticketPrice = ticketPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
