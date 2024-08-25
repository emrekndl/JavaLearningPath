package com.part2;

import org.springframework.beans.factory.annotation.Value;

// import org.springframework.stereotype.Component;

// Added import for @Component annotation
// @Component("database") --> no need to add this annotation since it is defined in IoCConfig class
public class MssqlCustomerDal implements ICustomerDal {

    // Using @Value annotation to inject property value from properties file
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
        System.out.println("Customer added to database with MSSQL");
    }

}
