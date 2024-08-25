package com.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Annotated Configuration class is used to bootstrap the context
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IoCConfig.class)) {
            ICustomerService customerService = context.getBean("service", CustomerManager.class);
            customerService.add();
            // ICustomerDal customerDal = context.getBean("database", ICustomerDal.class);
            // customerDal.add();
        }

    }
}
