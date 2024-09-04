package oving7;

public class DebitAccount extends AbstractAccount {

    @Override
    public void internalWithdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The withdrawed amount must be positive");
        } else if (super.getBalance() - amount < 0) {
            throw new IllegalStateException("The balance must be positive");
        } else {
            double newBalance = super.getBalance() - amount;
            super.setBalance(newBalance);
        }
    }

}
