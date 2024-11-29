package Data_Components;
import java.util.ArrayList;

public class Theatre {
    private String theatreName;
    private String location;
    private ArrayList<Movie> movieList;
    private ArrayList<Screen> screens;

    public Theatre(String theatreName, String location, ArrayList<Movie> movieList, ArrayList<Screen> screens) {
        this.theatreName = theatreName;
        this.location = location;

        this.movieList = new ArrayList<Movie>();
        if (movieList != null) {
            this.movieList.addAll(movieList);
        }

        this.screens = new ArrayList<Screen>();
        if (screens != null) {
            this.screens.addAll(screens);
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

    
    public void addMovie (Movie movie) {
        for (Movie m : movieList) {
            if (m == movie) {
                System.out.println("Movie" + movie.getMovieName() + 
                    " is already playing at theatre" + this.theatreName + ".");
                return;
            }
        }
        this.movieList.add(movie);
    }

    public void removeMovie(Movie movie) {
        movieList.remove(movie);
    }

    public ArrayList<Screen> getScreens() { return new ArrayList<>(this.screens); }
    public void setScreens(ArrayList<Screen> screens) { 
        this.screens = new ArrayList<>();
        this.screens.addAll(screens);
    }

    
    public void addScreen(String screenName, int rows, int cols) {
        Screen screen = new Screen(screenName, rows, cols);
        for (Screen s : screens) {
            if (s == screen) {
                return;
            }
        }
        this.screens.add(screen);
    }

    public void removeScreen(Screen screen) {
        this.screens.remove(screen);
    }


}