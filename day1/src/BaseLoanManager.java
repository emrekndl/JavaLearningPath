public class BaseLoanManager {
    public void calculate() {
        System.out.println("Loan calculated");
    }

    // public final double calculateInterestRate(double amount) {
    public double calculateInterestRate(double amount) {
        return amount * 1.18;
    }
}
