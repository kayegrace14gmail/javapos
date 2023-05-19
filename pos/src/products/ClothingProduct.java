package products;

// Define the concrete Products
public class ClothingProduct implements Product {

    private Long productID;
    private String category;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public ClothingProduct(String name, String description, double price, int quantity) {
        this.category = "Clothing";
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;

    }

    public ClothingProduct(Long productID, String name, String description, double price, int quantity) {
        this.productID = productID;
        this.category = "Clothing";
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
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

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
