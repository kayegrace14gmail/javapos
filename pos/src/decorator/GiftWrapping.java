/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import products.Product;

public class GiftWrapping implements Product {
    private final double giftWrapPrice = 2000.0;
    protected Product product;
    public GiftWrapping(Product product) {
       this.product = product;
   }
    
    
  @Override
     public String getName() {
        return product.getName() + "(G)";
    }
     
     @Override
     public String getCategory() {
         return product.getCategory();
     }

    @Override
    public String getDescription() {
        return product.getDescription();
//                " :Gift Wrapped";
    }

    @Override
    public double getPrice() {
        return product.getPrice() + giftWrapPrice;
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

    
    
  
