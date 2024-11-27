import java.util.ArrayList;

public class Theatre {
    private String theatreName;
    private String location;
    private ArrayList<Movie> movieList;
    private ArrayList<ArrayList<Seat>> seatMap;

    public Theatre(String theatreName, String location, ArrayList<Movie> movieList, ArrayList<ArrayList<Seat>> seatMap) {
        this.theatreName = theatreName;
        this.location = location;

        this.movieList = new ArrayList<Movie>();
        this.movieList.addAll(movieList);

        this.seatMap = new ArrayList<ArrayList<Seat>>();
        for (int i = 0; i < seatMap.size(); i++) {
            this.seatMap.add(i, new ArrayList<Seat>());
            this.seatMap.get(i).addAll(seatMap.get(i));
        }
        
    }

    public String getTheatreName() { return this.theatreName; } 
    public void setTheatreName(String theatreName) { this.theatreName = theatreName; }

    public String getLocation() { return this.location; }
    public void setLocation(String location) { this.location = location; }

    public ArrayList<Movie> getMovieList() { return new ArrayList<>(this.movieList); }
    public void setMovieList(ArrayList<Movie> movies) { 
        this.movieList = new ArrayList<>();
        this.movieList.addAll(movies);
    }

    
    public void addMovie (Movie movie) throws IllegalArgumentException {
        for (Movie m : movieList) {
            if (m == movie) {
                System.out.println("Movie" + movie.getMovieName() + 
                    " is already playing at theatre" + this.theatreName + ".");
            }
        }
        this.movieList.add(movie);
    }

    public void removeMovie(Movie movie) {
        movieList.remove(movie);
    }

}