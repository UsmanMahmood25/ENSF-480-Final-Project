package Data_Components;

import java.util.ArrayList;

public class Screen {
    private String screenName;
    private ArrayList<ArrayList<Seat>> seatMap;
    private int capacity;
    private int seatsAvailable;

    public Screen(String screenName, int rows, int cols) {
        this.screenName = screenName;
        this.seatMap = new ArrayList<ArrayList<Seat>>(rows);
        for (int i = 1; i <= rows; i++) {
            this.seatMap.add(new ArrayList<>(cols));
            for (int j = 1; j <= cols; j++) {
                this.seatMap.get(i - 1).add(new Seat(i, j));
            }
        }    
        this.capacity = rows * cols;
        this.seatsAvailable = this.capacity;
    }
    
    public String getScreenName() { return this.screenName; }
    public void setScreenName(String screenName) { this.screenName = screenName; }

    public ArrayList<ArrayList<Seat>> getSeatMap() { return new ArrayList<ArrayList<Seat>>(this.seatMap); }
    // this is removed since seats that live past the lifetime of screen violate composition principles
    // public void setSeatMap(ArrayList<ArrayList<Seat>> seatMap);

    public int getCapacity() {return this.capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public int getSeatsAvailable() {return this.seatsAvailable;}
    // no setter, this is logic is handled internally and should not be modified

    /*
     * Attempts to book seat at (ROW, COL). Returns 1 on success, 0 on failure (seat is already booked, or out of range).
     */
    public int bookSeat(int row, int col, User occupant) {
        if (seatMap.size() < row) {
            return 0;
        }
        if (seatMap.get(0).size() < col) {
            return 0;
        }
        if (seatMap.get(row - 1).get(col - 1).isOccupied()) {
            return 0;
        }
        if (seatMap.get(row - 1).get(col - 1).setOccupant(occupant) == 1) {
            seatsAvailable--;
            return 1;
        }
        return 0;
    }

    /*
     * Attempts to remove booking for seat at (ROW, COL). Returns 1 on success, 0 on failure (seat is not booked, or out of range).
     */

    public int cancelSeat(int row, int col) {
        if (seatMap.size() < row) {
            return 0;
        }
        if (seatMap.get(0).size() < col) {
            return 0;
        }
        if (!seatMap.get(row - 1).get(col - 1).isOccupied()) {
            return 0;
        }
        if (seatMap.get(row - 1).get(col - 1).removeOccupant() == 1) {
            seatsAvailable++;
            return 1;
        }
        return 0;
    }

}
