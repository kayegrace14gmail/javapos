package products;

// Define the concrete Products
import java.io.IOException;

public class BakeryProduct implements Product {

    private Long productID;
    private String category;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public BakeryProduct(String name, String description, double price, int quantity) {
        this.category = "Bakery";
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public BakeryProduct(Long productID, String name, String description, double price, int quantity) {
        this.productID = productID;
        this.category = "Bakery";
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Long getProductID() {
        return productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
