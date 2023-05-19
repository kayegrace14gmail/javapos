package products;
import java.util.ArrayList;
import java.util.List;

   public class ProductCatalog {
    // private constructor to prevent instantiation from outside
    private ProductCatalog() {}

    // static instance of the class
    private static ProductCatalog instance;

    // collection to store products
    private List<Product> productList = new ArrayList<>();

    // method to get the instance of the class
    public static ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    // method to add a product to the catalogue
    public void addProduct(Product product) {
        productList.add(product);
    }

    // method to remove a product from the catalogue
    public void removeProduct(Product product) {
        productList.remove(product);
    }
    
     public List<Product> getProducts() {
    //     // Get a list of all products in the catalog
            return productList;
    }
}
