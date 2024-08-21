public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        System.out.println("8 is prime: " + isPrime(5));

        CustomerManager customerManager = new CustomerManager();
        CustomerManager customerManager2 = new CustomerManager();
        customerManager = customerManager2;
        customerManager.add();

        FourOperations fourOperations = new FourOperations();
        System.out.println(fourOperations.addition(2, 3));

        // Encapsulation
        Product product2 = new Product(1, "Laptop", "Good Laptop", 30000, 3, "green");
        Product product = new Product();
        product.setName("Phone");
        product.setPrice(10000);
        product.setDescription("Good Phone");
        product.setStockAmount(3);
        product.setId(1);
        product.setColor("black");

        // System.out.println(product.name + " " + product.price);
        ProductManager productManager = new ProductManager();
        productManager.add(product);
        productManager.add(product2);

        System.out.println(product.getCode());

        // Inheritance
        Customer customer = new Customer();
        Employee employee = new Employee();
        System.out.println(employee.age + customer.age);

        EmployeeManager employeeManager = new EmployeeManager();
        CustomerManager customerManager3 = new CustomerManager();
        employeeManager.bestEmploye();
        customerManager3.list();

        MortgageLoanManager mortgageLoanManager = new MortgageLoanManager();
        mortgageLoanManager.calculate();

        // Polymorphism
        LoanUI loanUI = new LoanUI();
        loanUI.calculateLoan(new AutoLoanManager());

        // EmailLogger emailLogger = new EmailLogger();
        // emailLogger.log("Log message");

        BaseLogger[] loggers = new BaseLogger[] {
                new FileLogger(), new EmailLogger(), new DatabaseLogger()
        };
        for (BaseLogger logger : loggers) {
            logger.log("Log message");
        }

        EmptyManager emptyManager = new EmptyManager(new DatabaseLogger());
        emptyManager.add();

        // Override
        BaseLoanManager[] loanManagers = new BaseLoanManager[] {
                new AutoLoanManager(), new MortgageLoanManager(), new StudentLoanManager()
        };
        for (BaseLoanManager loanManager : loanManagers) {
            loanManager.calculate();
            System.out.println(loanManager.calculateInterestRate(10000));
        }

        // Abstraction
        BaseGameCalculate gameCalculate = new WomanGameCalculate();
        gameCalculate.calculate();
        gameCalculate.gameOver();
        BaseGameCalculate gameCalculate2 = new ManGameCalculate();
        gameCalculate2.calculate();
        gameCalculate2.gameOver();

        EmptyManager emptyManager2 = new EmptyManager(new DatabaseLogger());
        emptyManager2.databaseManager = new PostgresqlDatabaseManager();
        emptyManager2.getCustomers();

        // Interface
        ICustomerDal customerDal = new OracleCustomerDal();
        customerDal.Add();

        // Interface with Polymorphism
        EmptyManager emptyManager3 = new EmptyManager(new DatabaseLogger(), new MssqlCustomerDal());
        emptyManager3.addCustomer();

    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}