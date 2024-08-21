public class EmptyManager {

    private BaseLogger logger;
    BaseDatabaseManager databaseManager;
    private ICustomerDal customerDal;

    public EmptyManager(BaseLogger logger) {
        this.logger = logger;
    }

    public EmptyManager(BaseLogger logger, ICustomerDal customerDal) {
        this.logger = logger;
        this.customerDal = customerDal;
    }

    public void add() {
        logger.log("Customer added");
    }

    public void getCustomers() {
        databaseManager.getData();
    }

    public void addCustomer() {
        customerDal.Add();
    }
}
