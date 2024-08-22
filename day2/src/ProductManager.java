public class ProductManager {
    public void add(Product product) {
        if (ProductValidator.isValid(product)) {
            System.out.println("Product added: " + product.getName());
        }
        else {
            System.out.println("Invalid product: " + product.getName());
        }
    }
}
