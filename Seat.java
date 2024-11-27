public class Seat {
    private final int ROW;
    private final int COL;
    private boolean isOccupied;

    public Seat(int row, int col) {
        this.ROW = row;
        this.COL = col;
        this.isOccupied = false;
    }

    public int getRow() { return this.ROW; }
    public int getCol() { return this.COL; }
    public boolean isOccupied() { return this.isOccupied; }
    public void setOccupied() { this.isOccupied = true; }
    public void setUnoccupied() { this.isOccupied = false; }

}
