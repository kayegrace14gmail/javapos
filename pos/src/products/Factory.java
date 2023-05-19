package products;

// Define the Factory interface
public interface Factory {

    public Product createProduct(String name, String description, double price, int quantity);
}
