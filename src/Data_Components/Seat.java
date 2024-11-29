package Data_Components;
public class Seat {
    private final int ROW;
    private final int COL;
    private boolean isOccupied;
    private User occupant;

    public Seat(int row, int col) {
        this.ROW = row;
        this.COL = col;
        this.isOccupied = false;
        this.occupant = null;
    }

    public int getRow() { return this.ROW; }
    public int getCol() { return this.COL; }
    public boolean isOccupied() { return this.isOccupied; }
    public void setOccupied() { this.isOccupied = true; }
    public void setUnoccupied() { this.isOccupied = false; }
    public User getOccupant() { return this.occupant; }

    /*
     * returns 1 on success, 0 on failure
     */
    public int removeOccupant() {
        if (!this.isOccupied) {
            return 0;
        }
        this.occupant = null;
        this.isOccupied = false;
        return 1;
    }

    /*
     * returns 1 on success, 0 on failure
     */
    public int replaceOccupant(User occupant) {
        if (!this.isOccupied) {
            return 0;
        }
        this.occupant = occupant;
        return 1;
    }

    /*
     * returns 1 on success, 0 on failure
     */
    public int setOccupant(User occupant) {
        if (this.isOccupied) {
            return 0;
        }
        this.occupant = occupant;
        this.isOccupied = true;
        return 1;
    }

}
