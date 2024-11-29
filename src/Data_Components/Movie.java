package Data_Components;
public class Movie {
    private final int MOVIE_ID;
    private String movieName;
    private String genre;
    private double durationMinutes;
    private String description;
    private static int counter = 0;

    public Movie(String movieName, String genre, double durationMinutes, String description) {
        this.MOVIE_ID = counter++;
        this.movieName = movieName;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
        this.description = description;
    }

    public int getMovieID() { return this.MOVIE_ID; }

    public String getMovieName() { return this.movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getGenre() { return this.genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public double getDuration() { return this.durationMinutes; }
    public void setDuration(double durationMinutes) { this.durationMinutes = durationMinutes; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

}
