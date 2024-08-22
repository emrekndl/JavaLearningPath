public class ProductValidator {
    public static boolean isValid(Product product) {
        // Check if the product name is not null and not empty
        if (product.getName() == null || product.getName().isEmpty()) {
            return false;
        }

        // Check if the product price is greater than 0
        if (product.getPrice() < 0) {
            return false;
        }

        // If all checks pass, the product is valid
        return true;
    }
}
