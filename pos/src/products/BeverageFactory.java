
package products;

// Define the concrete Factories
public class BeverageFactory implements Factory {
    
    
    @Override
    public Product createProduct(String name, String description, double price, int quantity) {
        return new BeverageProduct(name, description, price, quantity);
    }
}
