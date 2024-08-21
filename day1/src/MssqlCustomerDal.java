public class MssqlCustomerDal implements ICustomerDal, IRepository {

    public void Add() {
        System.out.println("Adding customer to MSSQL database");
    }

}
