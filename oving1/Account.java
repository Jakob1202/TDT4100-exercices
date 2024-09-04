package oving1;

public class Account {
    private double balance;
    private double interestRate;

    /**
     * Constructor for account
     * 
     * @param balance      the balance in this account
     * @param interestRate the interest rate in this account
     */
    public Account(double balance, double interestRate) {
        if (balance >= 0 && interestRate >= 0) {
            this.balance = balance;
            this.interestRate = interestRate;
        } else {
            throw new IllegalArgumentException("The balance and interest rate must be positive");
        }
    }

    /**
     * Default constructor for account
     */
    public Account() {
        this.balance = 0.0;
        this.interestRate = 0.0;
    }

    /**
     * Method to make a deposit to this account
     * 
     * @param amount the amount to add to this account
     */
    public void deposit(double amount) {
        if (amount < 0) {
            return;
            // throw new IllegalArgumentException("The amount must be positive");
        }
        this.balance += amount;
    }

    /**
     * Method to make a withdraw to this account
     * 
     * @param amount the amount to remove from this account
     */
    public void withdraw(double amount) {
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("The balance must be positive");
        }
        this.balance -= amount;
    }

    /**
     * Method to add interest to this account
     */
    public void addInterest() {
        this.balance *= (1 + (interestRate / 100));
    }

    /**
     * Method to get the balance to this account
     * 
     * @return the balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Method to get the interest rate to this account
     * 
     * @return the interest rate
     */
    public double getInterestRate() {
        return this.interestRate;
    }

    /**
     * Method to set this interest rate to a new interest rate
     * 
     * @param newInterestRate a new interest rate
     */
    public void setInterestRate(double newInterestRate) {
        if (newInterestRate < 0) {
            throw new IllegalArgumentException();
        }
        this.interestRate = newInterestRate;
    }

    @Override
    public String toString() {
        return "Account [balance=" + this.balance + ", interestRate=" + this.interestRate + "]";
    }

    public static void main(String[] args) {
        Account account = new Account(10000, 2.5);
    }
}
