package oving7;

public class BSU extends SavingsAccount {
    private double maxAnnualDeposit;
    private double currentYearDeposit;
    private double lastYearBalance;

    /**
     * Constructor for BSU
     * 
     * @param interestRate the interest rate to this BSU
     * @param maxBalance   the maximum annual deposit amount to this BSU
     */
    public BSU(double interestRate, double maxAnnualDeposit) {
        super(interestRate);
        if (maxAnnualDeposit < 0) {
            throw new IllegalArgumentException("The maximum balance cannot be negative");
        } else {
            this.maxAnnualDeposit = maxAnnualDeposit;
            this.currentYearDeposit = 0;
            this.lastYearBalance = 0;
        }
    }

    /**
     * Method to get the tax deduction to this BSU for the last year
     * 
     * @return the tax deduction
     */
    public double getTaxDeduction() {
        return this.lastYearBalance * 0.20;
    }

    @Override
    public void deposit(double amount) {
        if (this.currentYearDeposit + amount > this.maxAnnualDeposit) {
            throw new IllegalStateException("Cannot deposit more than the max balance");
        } else {
            super.deposit(amount);
            this.currentYearDeposit += amount;
            this.lastYearBalance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > this.currentYearDeposit) {
            throw new IllegalStateException("Cannot withdraw more amount than deposited this year");
        }
        super.withdraw(amount);
        this.currentYearDeposit -= amount;
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.currentYearDeposit = 0;
        this.lastYearBalance = 0;
    }

}
