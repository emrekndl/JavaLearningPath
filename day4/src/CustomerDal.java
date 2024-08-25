
public class CustomerDal implements ICustomerDal {

    // Reusing existing property
    String connectionString;
    public String getConnectionString() {
        return connectionString;
    }
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    @Override
    public void add() {
        System.out.println("Connection String: " + this.getConnectionString());
        System.out.println("Customer added to database with Oracle");

    }

}
