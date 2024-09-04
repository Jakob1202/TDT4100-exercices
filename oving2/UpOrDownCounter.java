package oving2;

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
            this.countDown = true;
        } else {
            this.countDown = false;
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
        return this.counter;
    }

    /**
     * Method to count to this up or down counter
     * 
     * @return true if this counter have reached this end, false otherwise
     */
    public boolean count() {
        if (this.counter == this.end) {
            return false;
        } else {
            if (this.countDown) {
                this.counter -= 1;
                if (this.counter <= this.end) {
                    return false;
                } else {
                    return true;
                }
            } else {
                this.counter += 1;
                if (this.counter >= this.end) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        UpOrDownCounter counter = new UpOrDownCounter(1, 3);
        for (int i = 0; i < 10; i++) {
            counter.count();
            System.out.println(counter.getCounter());
            System.out.println(counter.count());
        }

    }
}
