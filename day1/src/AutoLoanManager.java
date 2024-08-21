public class AutoLoanManager extends BaseLoanManager {

    @Override
    public void calculate() {
        System.out.println("Auto loan calculated");
    }

    @Override
    public double calculateInterestRate(double amount) {
        return amount * 1.10;
    }

}
