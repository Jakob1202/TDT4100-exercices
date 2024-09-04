package oving7;

public class ForeldreSpar extends SavingsAccount {

    private int maxAnnualWithdrawals;
    private int currentYearWithdrawals;

    public ForeldreSpar(double interestRate, int maxAnnualWithdrawals) {
        super(interestRate);

        if (maxAnnualWithdrawals < 0) {
            throw new IllegalArgumentException("The maximum withdrawals count must be positive");
        } else {
            this.maxAnnualWithdrawals = maxAnnualWithdrawals;
            this.currentYearWithdrawals = maxAnnualWithdrawals;
        }
    }

    public int getRemainingWithdrawals() {
        return this.currentYearWithdrawals;
    }

    @Override
    public void withdraw(double amount) {
        if (this.currentYearWithdrawals == 0) {
            throw new IllegalStateException("Cannot deposit amount from the account this year");
        } else {
            super.withdraw(amount);
            this.currentYearWithdrawals--;
        }
    }

    @Override
    public void endYearUpdate() {
        super.endYearUpdate();
        this.currentYearWithdrawals = this.maxAnnualWithdrawals;
    }

}
