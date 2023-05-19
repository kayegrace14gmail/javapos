package products;

// Define the concrete Factories
public class ClothingFactory implements Factory {

    @Override
    public Product createProduct(String name, String description, double price, int quantity) {
        return new ClothingProduct(name, description, price, quantity);
    }
}
