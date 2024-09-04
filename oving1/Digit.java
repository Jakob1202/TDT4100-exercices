package oving1;

public class Digit {
    private int digit;
    private int digitValue;

    /**
     * Constructor for digit
     * 
     * @param digit the digit
     */
    public Digit(int digit) {
        if (digit <= 36 && digit >= 0) {
            this.digit = digit;
            this.digitValue = 0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method to get this digit value
     * 
     * @return the digit value
     */
    public int getValue() {
        return this.digitValue;
    }

    /**
     * Method to increase this digit value by 1
     * 
     * @return true if this digit value reaches this digit and resets this value to
     *         0, false otwerwise
     */
    public boolean increment() {
        this.digitValue += 1;
        if (this.digit == this.digitValue) {
            this.digitValue = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to get this digt
     * 
     * @return the digit
     */
    public int getBase() {
        return this.digit;
    }

    @Override
    public String toString() {
        return (Integer.toHexString(this.digitValue)).toUpperCase();
    }
}
