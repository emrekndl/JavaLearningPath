
public class CustomerManager implements ICustomerService {
    private ICustomerDal customerDal;

    // Setter injection
    public void setCustomerDal(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    // Constructor injection
    // public CustomerManager(ICustomerDal customerDal) {
    //     this.customerDal = customerDal;
    // }

    public void add() {
        customerDal.add();
    }
}
