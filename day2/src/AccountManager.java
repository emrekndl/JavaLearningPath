public class AccountManager {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws BalanceInsufficentException {
        if (balance >= amount) {
            balance -= amount;
        }
        else {
            throw new BalanceInsufficentException("There is an insufficient fund to complete the withdrawal. "
                    + "Current balance is: " + balance + " Amount is: " + amount);
        }
    }

    public double getBalance() {
        return this.balance;
    }
}