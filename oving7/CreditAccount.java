package oving7;

public class CreditAccount extends AbstractAccount {

    private double creditLine;

    /**
     * Constructor for credit account
     * 
     * @param credit the credit line
     */
    public CreditAccount(double creditLine) {
        this.setCreditLine(creditLine);
    }

    @Override
    public void internalWithdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The withdrawed amount must be positive");
        } else if (super.getBalance() - amount + this.creditLine < 0) {
            throw new IllegalStateException("The balance must be zero or positive");
        } else {
            double newBalance = super.getBalance() - amount;
            super.setBalance(newBalance);
        }
    }

    /**
     * Method to set the credit line to this credit account
     * 
     * @param the new credit line
     */
    public void setCreditLine(double newCreditLine) {
        if (newCreditLine < 0) {
            throw new IllegalArgumentException("The credit line must be zero or positive");
        } else if (super.getBalance() + newCreditLine < 0) {
            throw new IllegalStateException("The credit line cannot cover for the negative balance");
        } else {
            this.creditLine = newCreditLine;
        }
    }

    /**
     * Method to get the credit line to this credit account
     * 
     * @return the credit line
     */
    public double getCreditLine() {
        return this.creditLine;
    }

}
