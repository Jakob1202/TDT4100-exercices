package oving7;

public class SavingsAccount implements Account {
    private double balance;
    private double interestRate;

    /**
     * Constructor for savings account
     * 
     * @param balance      the balance in this savings account
     * @param interestRate the interest rate in this savings account
     */
    public SavingsAccount(double interestRate) {
        this.setBalance(0);
        this.setInterestRate(interestRate);
    }

    /**
     * Method to calculate the interest to this savings account for this year. Makes
     * a signal that it is now a new year
     */
    public void endYearUpdate() {
        this.balance = this.balance * ((1 + this.interestRate));
    }

    /**
     * Method to make a deposit to this savings account
     * 
     * @param amount the amount to be added to this savings account
     */
    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount must be positive");
        }
        this.balance += amount;
    }

    /**
     * Method to make a withdraw to this savings account
     * 
     * @param amount the amount to remove from this savings account
     */
    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The withdrawed amount must be positive");
        } else if (this.balance - amount < 0) {
            throw new IllegalStateException("The balance must be positive");
        }
        this.balance -= amount;
    }

    /**
     * Method to set the balance to this savings account
     * 
     * @return the new balance
     */
    public void setBalance(double newBalance) {
        if (newBalance < 0) {
            throw new IllegalArgumentException("The new balance must be zero or positive");
        } else {
            this.balance = newBalance;
        }
    }

    /**
     * Method to get the balance to this savings account
     * 
     * @return the balance
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

    /**
     * Method to set the interest rate to this savings account
     * 
     * @param newInterestRate the new interest rate
     */
    public void setInterestRate(double newInterestRate) {
        if (newInterestRate < 0) {
            throw new IllegalArgumentException("The interest rate must be positive");
        } else {
            this.interestRate = newInterestRate;
        }
    }

    /**
     * Method to get the interest rate to this account
     * 
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

}
