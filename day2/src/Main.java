import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

import BasicMath.FourOperations;
import BasicMath.Logarithm;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) {
        // Static
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Laptop");
        product1.setPrice(1000.0);

        ProductManager productManager = new ProductManager();
        productManager.add(product1);

        // DatabaseHelper.Crud.create();

        // Packages
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("You entered: " + number);
        scanner.close();

        int result = FourOperations.add(5, 3);
        System.out.println("Result: " + result);

        double result2 = Logarithm.log(8, 2);
        System.out.println("Logarithm: " + result2);

        // Collections
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("Hello");
        list.add(3.14);

        list.set(1, "World");
        System.out.println(list);

        list.remove(0);
        System.out.println(list.get(0));
        // list.clear();
        System.out.println(list.size());

        for (Object obj : list) {
            System.out.println(obj);
        }

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Hello");
        list2.add("World");
        list2.add("Java");
        list2.add("Programming");

        list2.remove("Java");
        Collections.sort(list2);
        for (String str : list2) {
            System.out.println(str);
        }

        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "Foo", "one"));
        customers.add(new Customer(1, "Bar", "two"));
        Customer baz = new Customer(1, "Baz", "three");
        customers.add(baz);

        customers.remove(baz);
        for (Customer customer : customers) {
            System.out.println(customer.getFirstName());
        }

        // Hashmap
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        System.out.println(dict.size());

        for (String key : dict.keySet()) {
            System.out.println(key + ": " + dict.get(key));
        }

        dict.remove("two");
        // dict.clear();
        System.out.println(dict.get("two"));

        // Exception Handling
        try {
            int[] numbers = {
                    1, 2, 3
            };
            System.out.println(numbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block");
        }

        BufferedReader reader = null;
        int total = 0;
        try {
            reader = new BufferedReader(new FileReader("day2/src/file.txt"));
            String line = reader.readLine();
            while (line != null) {
                total += Integer.valueOf(line);
                // System.out.println(line);
                line = reader.readLine();
            }
            System.out.println("Total: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                // Or use this -> public static void main throw IOException
                try {
                    reader.close();
                } catch (Exception e) {
                    System.out.println("An error occurred while closing the file: " + e.getMessage());
                }
            }
        }

        AccountManager accountManager = new AccountManager();
        accountManager.deposit(1000.0);
        try {
            accountManager.withdraw(500.0);
        } catch (BalanceInsufficentException e) {
            e.printStackTrace();
        }
        System.out.println("Balance: " + accountManager.getBalance());
        try {
            accountManager.withdraw(600.0);
        } catch (BalanceInsufficentException e) {
            e.printStackTrace();
        }

        // Files
        createFile("day2/src/file2.txt");
        getFileInfo("day2/src/file.txt");
        writeFile("day2/src/file2.txt");
        readFile("day2/src/file2.txt");

        // Generics
        MyList<String> list3 = new MyList<String>();
        list3.add("Hello");
        list3.add("World");
        // Repository Design Pattern Demo
        CustomerDal customerDal = new CustomerDal();
        customerDal.add(new Customer(1, "Foo", "Bar"));
        customerDal.add(new Customer(2, "Baz", "Qux"));

        ProductDal productDal = new ProductDal();
        productDal.add(new Product(1, "Laptop", 1000.0));
        productDal.add(new Product(2, "Phone", 500.0));
        // Generic Method
        Validator validator = new Validator();
        System.out.println(validator.isValid(product1));
        System.out.println(validator.isValid(new Customer(3, "Qux", "Quux")));

        // Threading
        ChronometerThread chronoThread1 = new ChronometerThread("thread A");
        ChronometerThread chronoThread2 = new ChronometerThread("thread B");
        ChronometerThread chronoThread3 = new ChronometerThread("thread C");
        chronoThread1.start();
        chronoThread2.start();
        chronoThread3.start();

    }

    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void getFileInfo(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("File size: " + file.length());
            System.out.println("File readable: " + file.canRead());
            System.out.println("File writable: " + file.canWrite());
        }
        else {
            System.out.println("File does not exist.");
        }
    }

    public static void readFile(String fileName) {
        File file = new File(fileName);
        // java 7 after try with resources usage. AutoCloseable interface
        if (file.exists()) {
            try (Scanner reader = new Scanner(file)) {
                System.out.println("Reading " + file.getName() + " file line by line:");
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(String fileName) {
        // try (FileWriter writer = new FileWriter(fileName, true)) {
        // writer.write("New line added!");
        // }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.newLine();
            bufferedWriter.write("New line added!");
            // bufferedWriter.write("New line added!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
