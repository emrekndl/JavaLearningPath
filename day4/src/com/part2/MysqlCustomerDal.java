package com.part2;

import org.springframework.beans.factory.annotation.Value;

public class MysqlCustomerDal implements ICustomerDal {

    @Value("${database.connectionString}")
    String connectionString;
    public String getConnectionString() {
        return connectionString;
    }
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    @Override
    public void add() {
        System.out.println("Connection String: " + this.connectionString);
        System.out.println("Customer added to database with MySQL");
    }

}
