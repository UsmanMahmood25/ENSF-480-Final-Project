package Data_Components;
import java.util.Date;

public class Showtime {
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private Date showDate;
    private Date announceDate;
    private double ticketPrice;

    public Showtime(Movie movie, Theatre theatre, Screen screen, Date showDate, Date announceDate, double ticketPrice) {
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.showDate = showDate;
        this.announceDate = announceDate;
        this.ticketPrice = ticketPrice;
    }

    public Movie getMovie() { return this.movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Theatre getTheatre() { return this.theatre; }
    public void setTheatre(Theatre theatre) { this.theatre = theatre; }

    public Screen getRoom() { return this.screen; }
    public void setRoom(Screen screen) { this.screen = screen; }

    public Date getShowDate() { return this.showDate; }
    public void setShowDate(Date showDate) { this.showDate = showDate; }

    public Date getAnnounceDate() { return this.announceDate; }
    public void setAnnounceDate(Date announceDate) { this.announceDate = announceDate; }

    public double getTicketPrice() { return this.ticketPrice; }
    public void setTicketPrice(double ticketPrice) { this.ticketPrice = ticketPrice; }
}