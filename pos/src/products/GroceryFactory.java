package products;

public class GroceryFactory implements Factory {

    @Override
    public Product createProduct(String name, String description, double price, int quantity) {
        return new GroceryProduct(name, description, price, quantity);
    }
}
