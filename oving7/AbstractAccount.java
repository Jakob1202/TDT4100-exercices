package oving7;

public abstract class AbstractAccount {
    private double balance = 0;

    /**
     * Method to make a deposit to this account
     * 
     * @param amount the amount to be added to this account
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount must be positive");
        }
        this.balance += amount;
    }

    /**
     * Method to make a withdraw to this account
     * 
     * @param amount the amount to removed from this account
     */
    public void withdraw(double amount) {
        this.internalWithdraw(amount);
    }

    /**
     * Method to withdraw amount from this account that subclasses
     * implements
     * 
     * @param amount the amount to be removed from this account
     */
    public abstract void internalWithdraw(double amount);

    /**
     * Method to set the balance to this savings account
     * 
     * @return the new balance
     */
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    /**
     * Method to get the balance to this savings account
     * 
     * @return the balance
     */
    public double getBalance() {
        return this.balance;
    }
}
