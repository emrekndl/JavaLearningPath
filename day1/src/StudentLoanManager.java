public class StudentLoanManager extends BaseLoanManager {

    @Override
    public void calculate() {
        System.out.println("Student loan calculated");
    }

    @Override
    public double calculateInterestRate(double amount) {
        return amount * 1.01;
    }

}
