package products;

// Define the concrete Factories
public class BakeryFactory implements Factory {

    @Override
    public Product createProduct(String name, String description, double price, int quantity) {
        return new BakeryProduct(name, description, price, quantity);
    }
}
