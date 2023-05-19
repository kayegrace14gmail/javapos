/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import products.Product;

/**
 *
 * @author @author Kaye
 */
public class ExpressShipping implements Product {
    private final double expressShippingPrice = 3000.0;
    protected Product product;
    
    public ExpressShipping(Product product) {
       this.product = product;
   }
    
    
  @Override
     public String getName() {
        return product.getName() + "(E)";
    }
     
     @Override
     public String getCategory() {
         return product.getCategory();
     }

    @Override
    public String getDescription() {
        return product.getDescription();
//                " :Express Shipped";
    }

    @Override
    public double getPrice() {
        return product.getPrice() + expressShippingPrice;
    }

    @Override
    public Long getProductID() {
        return product.getProductID();
    }

    @Override
    public int getQuantity() {
        return product.getQuantity();
    }
    
    @Override
    public void setQuantity(int quantity) {
        product.setQuantity(quantity);
    }
}

