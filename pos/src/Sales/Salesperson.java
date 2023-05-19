/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales;

import products.Product;

/**
 *
 * @author @author Kaye
 */
public class Salesperson implements CartObserver {
    private String salespersonName;

    public Salesperson(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }
    
    @Override
    public void update(Product product, int quantity_taken) {
        System.out.println("Salesperson " + salespersonName + " notified that " + quantity_taken + " piece(s) of " + product.getName() + " has been added to cart.");
        System.out.println("\n");
    }
}





