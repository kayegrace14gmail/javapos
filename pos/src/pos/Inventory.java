/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import persist.DBConnection;
import persist.ProductDAOImpl;
import products.BakeryFactory;
import products.BeverageFactory;
import products.ClothingFactory;
import products.CosmeticsFactory;
import products.ElectronicsFactory;
import products.Factory;
import products.GroceryFactory;
import products.Product;

/**
 *
 * @@author Kaye
 */
public class Inventory {

    public static void registerProduct() throws ClassNotFoundException, SQLException, IOException {

        String name;
        String description;
        double price;
        int quantity;
        int type;

        ProductDAOImpl productDAOImpl = new ProductDAOImpl(DBConnection.accessConnection());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("%-13s %10s", "Bakery:", "1");
        System.out.println("\n");
        System.out.printf("%-13s %10s", "Beverage:", "2");
        System.out.println("\n");
        System.out.printf("%-13s %10s", "Clothing:", "3");
        System.out.println("\n");
        System.out.printf("%-13s %10s", "Cosmetics:", "4");
        System.out.println("\n");
        System.out.printf("%-13s %10s", "Electronics:", "5");
        System.out.println("\n");
        System.out.printf("%-13s %10s", "Grocery:", "6");
        System.out.println("\n");
        
        
        System.out.println("Enter Product Category: ");
        type = Integer.parseInt(reader.readLine());
        System.out.println("Enter product Name: ");
        name = reader.readLine();
        System.out.println("Enter product Description: ");
        description = reader.readLine();
        System.out.println("Enter product price: ");
        price = Double.parseDouble(reader.readLine());
        System.out.println("Enter the Quantity stocked: ");
        quantity = Integer.parseInt(reader.readLine());

        switch (type) {
            case 1 -> {
                Factory bakery = new BakeryFactory();
                Product bakeryproduct = bakery.createProduct(name, description, price, quantity);
                productDAOImpl.addProduct(bakeryproduct);
               
            }
            case 2 -> {
                Factory beverage = new BeverageFactory();
                Product beverageproduct = beverage.createProduct(name, description, price, quantity);
                productDAOImpl.addProduct(beverageproduct);
                
            }
            case 3 -> {
                Factory clothing = new ClothingFactory();
                Product clothingproduct = clothing.createProduct(name, description, price, quantity);
                productDAOImpl.addProduct(clothingproduct);
                
            }
            case 4 -> {
                Factory cosmetics = new CosmeticsFactory();
                Product cosmeticsproduct = cosmetics.createProduct(name, description, price, quantity);
                productDAOImpl.addProduct(cosmeticsproduct);
                
            }
            case 5 -> {
                Factory electronics = new ElectronicsFactory();
                Product electronicsproduct = electronics.createProduct(name, description, price, quantity);
                productDAOImpl.addProduct(electronicsproduct);
                
            }
            case 6 -> {
                Factory grocery = new GroceryFactory();
                Product groceryproduct = grocery.createProduct(name, description, price, quantity);
                productDAOImpl.addProduct(groceryproduct);
                
            }
            default ->
                System.out.println("Product was not added check inputs");
        }

    }
    
    public static void searchProduct() throws ClassNotFoundException, SQLException, IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the product barcode: ");
       Long searchID = Long.valueOf(reader.readLine());
       ProductDAOImpl productDAOImpl = new ProductDAOImpl(DBConnection.accessConnection());
       Product searchedProduct = productDAOImpl.getProductById(searchID);
//       print the product details
        System.out.println("ProductID: " + searchedProduct.getProductID());
        System.out.println("Name: " + searchedProduct.getName());
        System.out.println("Description: " + searchedProduct.getDescription());
        System.out.println("Price: " + searchedProduct.getPrice());
        System.out.println("Category: " + searchedProduct.getCategory());
        System.out.println("Quantity left: " + searchedProduct.getQuantity());
    }
    
    public static void addStock() throws IOException, ClassNotFoundException, SQLException  {
       Long searchID;
       int new_stock;
       int quantity_availabe;
       int new_quantity;
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the product barcode: ");
       searchID = Long.valueOf(reader.readLine());
       ProductDAOImpl productDAOImpl = new ProductDAOImpl(DBConnection.accessConnection());
       Product product_to_update = productDAOImpl.getProductById(searchID);
       quantity_availabe = product_to_update.getQuantity();
       System.out.println("Quantity available : " + quantity_availabe);
        System.out.println("Enter the new quantity to be added:");
       new_stock = Integer.parseInt(reader.readLine());
       new_quantity = quantity_availabe + new_stock;
       product_to_update.setQuantity(new_quantity);
       productDAOImpl.updateProduct(product_to_update);
        System.out.println("Quantity updated successfully to: " + new_quantity);
    }
}
