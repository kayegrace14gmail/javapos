package products;

// Define the concrete Factories
public class ElectronicsFactory implements Factory {

    @Override
    public Product createProduct(String name, String description, double price, int quantity) {
        return new ElectronicsProduct(name, description, price, quantity);
    }
}
