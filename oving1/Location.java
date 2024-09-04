package oving1;

public class Location {
    private int x;
    private int y;

    /**
     * Method to move up
     */
    public void up() {
        this.y -= 1;
    }

    /**
     * Method to move down
     */
    public void down() {
        this.y += 1;
    }

    /**
     * Method to move left
     */
    public void left() {
        this.x -= 1;
    }

    /**
     * Method to move right
     */
    public void right() {
        this.x += 1;
    }

    /**
     * Method to get the x position to this location
     * 
     * @return the x position
     */
    public int getX() {
        return this.x;
    }

    /**
     * Method to get the y position to this location
     * 
     * @return the y position
     */
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Location [x=" + this.x + ", y=" + this.y + "]";
    }
}
