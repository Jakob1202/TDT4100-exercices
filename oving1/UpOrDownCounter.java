package oving1;

public class UpOrDownCounter {

    private int start;
    private int end;
    private int counter;
    private boolean countDown;

    /**
     * Constructor for up or down counter
     * 
     * @param start the start to count from
     * @param end   the end to count to
     */
    public UpOrDownCounter(int start, int end) {
        if (start == end) {
            throw new IllegalArgumentException("End number must be higher or equal to start number");
        } else if (start > end) {
            countDown = true;
        } else {
            countDown = false;
        }

        this.start = start;
        this.end = end;
        this.counter = start;
    }

    /**
     * Method to get the counter to this up or down counter
     * 
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Method to count to this up or down counter
     * 
     * @return true if this counter have reached this end, false otherwise
     */
    public boolean count() {
        if (counter == end) {
            return false;
        } else {
            if (countDown) {
                counter -= 1;
                if (counter <= end) {
                    return false;
                } else {
                    return true;
                }
            } else {
                counter += 1;
                if (counter >= end) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}
