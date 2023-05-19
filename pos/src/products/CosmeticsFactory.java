// Define the concrete Factories

package products;

public class CosmeticsFactory implements Factory {
    @Override
    public Product createProduct(String name, String description, double price, int quantity) {
        return new CosmeticsProduct(name, description, price, quantity);
    }
}

