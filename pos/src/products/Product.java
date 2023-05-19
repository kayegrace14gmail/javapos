// Define the Product interface
package products;

import java.io.Serializable;

public interface Product {

    public String getName();

    public String getCategory();

    public String getDescription();

    public double getPrice();

    public Long getProductID();

    public int getQuantity();

    public void setQuantity(int quantity);

}
