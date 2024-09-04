package oving7;

public class SavingsAccount2 extends AbstractAccount {
    private int maxWithdrawals;
    private double fee;
    private int currentWithdrawals;

    public SavingsAccount2(int maxWithdrawals, double fee) {
        if (maxWithdrawals < 0 || fee <= 0) {
            throw new IllegalArgumentException(
                    "The maximum withdrawals count must be positive and the fee must be above zero");
        } else {
            this.maxWithdrawals = maxWithdrawals;
            this.fee = fee;
            this.currentWithdrawals = 0;
        }
    }

    @Override
    public void internalWithdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The withdrawed amount must be positive");
        } else if (super.getBalance() - amount < 0) {
            throw new IllegalStateException("The balance must be positive");
        } else if (this.currentWithdrawals >= this.maxWithdrawals) {
            if (super.getBalance() - amount - this.fee < 0) {
                throw new IllegalStateException("The withdrawed amount and corresponding fees must be positive");
            } else {
                double newBalance = super.getBalance() - amount - this.fee;
                super.setBalance(newBalance);

                this.currentWithdrawals++;
            }
        } else {
            double newBalance = super.getBalance() - amount;
            super.setBalance(newBalance);
            this.currentWithdrawals++;
        }
    }
}
