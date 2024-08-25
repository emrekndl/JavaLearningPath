
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws BeansException {
        // IoC (Inversion of Control) principle with dependency injection

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            ICustomerService customerService = context.getBean("service", ICustomerService.class);
            customerService.add();
            // CustomerManager customerManager = new CustomerManager(context.getBean("database", ICustomerDal.class));
            // CustomerManager customerManager = new CustomerManager(new CustomerDal());
            // customerManager.add();
        }

    }
}
