package products;

public class GroceryProduct implements Product {

    private Long productID;
    private String category;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public GroceryProduct(String name, String description, double price, int quantity) {
        this.category = "Grocery";
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public GroceryProduct(Long productID, String name, String description, double price, int quantity) {
        this.productID = productID;
        this.category = "Grocery";
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
