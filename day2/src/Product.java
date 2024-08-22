public class Product implements IEntity {
    int id;
    String name;
    double price;

    public Product() {
    }

    public Product(int i, String string, double d) {
        this.id = i;
        this.name = string;
        this.price = d;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
