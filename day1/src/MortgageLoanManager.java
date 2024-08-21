public class MortgageLoanManager extends BaseLoanManager {

    @Override
    public void calculate() {
        System.out.println("Mortgage loan calculated");
    }

    @Override
    public double calculateInterestRate(double amount) {
        return amount * 1.20;
    }

}
