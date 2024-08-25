package com.part2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Confirm @Configuration annotation class file
@Configuration
// CompoentScan annotation scans package and sub-packages for bean definitions
@ComponentScan("com.part2")
// PropertySources annotation loads properties file
// @PropertySources("classpath:values.properties")
@PropertySource("file:day4/values.properties")
// @PropertySource("classpath:values.properties")
public class IoCConfig {
    @Bean
    public ICustomerDal database() {
        return new MssqlCustomerDal();
    }
   
    @Bean
    public ICustomerService service() {
       return new CustomerManager(database()); 
    }
}
