/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos;

import Payment.CashPayment;
import Payment.CreditCardPayment;
import Payment.PaymentStrategy;
import Sales.Cart;
import Sales.CartObserver;
import Sales.Salesperson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import persist.DBConnection;
import persist.ProductDAOImpl;
import persist.TransactionDAOImpl;
import products.ProductCatalog;

/**
 *
 * @author Khalid
 */
public class Shopping {

    public static void shopping() throws SQLException, ClassNotFoundException, IOException {
        String observer;
        String barcode;
        int quantity;
        PaymentStrategy payment;
        String payment_option;
        boolean giftwrapped;
        boolean express_shipped;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ProductDAOImpl productDAOImpl = new ProductDAOImpl(DBConnection.accessConnection());

        TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl(DBConnection.accessConnection());

        productDAOImpl.getAllProducts();

        ProductCatalog productcatalog = ProductCatalog.getInstance();

        Cart cart = Cart.getInstance(productcatalog.getProducts());

//        add observers now
        System.out.println("============= Enter salespersonnel Now =============");
        while (true) {
            System.out.println("Enter salesperson: ");
            observer = reader.readLine();

            if (observer.equals(">")) {
                break;
            } else {
                CartObserver cartobserver = new Salesperson(observer);
                cart.addObserver(cartobserver);
                System.out.println("Salesperson " + observer + " added successfully");
            }
        }

//        add products now
        System.out.println("============= Enter products Now =============");
        while (true) {
            System.out.println("Enter product barcode: ");
            barcode = reader.readLine();

            if (barcode.equals(">")) {
                break;
            } else {
                
//              Enter the quantity purchased
                System.out.println("Enter quantity: ");
                quantity = parseInt(reader.readLine());

//            configuring gift wrapping
                System.out.println("=================Gift wrapping? (y/n)======================");
                OUTER_1:
                while (true) {
                    String input = reader.readLine().toLowerCase();
                    switch (input) {
                        case "y" -> {
                            giftwrapped = true;
                            break OUTER_1;
                        }
                        case "n" -> {
                            giftwrapped = false;
                            break OUTER_1;
                        }
                        default ->
                            System.out.println("Invalid input. Please enter y or n.");
                    }
                }

//      configuring express shipping
                System.out.println("Do you want express shipping? (y/n)");
                OUTER:
                while (true) {
                    String input = reader.readLine().toLowerCase();
                    switch (input) {
                        case "y" -> {
                            express_shipped = true;
                            break OUTER;
                        }
                        case "n" -> {
                            express_shipped = false;
                            break OUTER;
                        }
                        default ->
                            System.out.println("Invalid input. Please enter y or n.");
                    }
                }
                
//                adding products to the cart
                cart.addProduct(Long.valueOf(barcode), quantity, giftwrapped, express_shipped);
            }

        }

//        cart.addProduct(1002232212146L, 1);
//        set payment strategy
        System.out.println("============= Enter payment option =============");
        while (true) {
            System.out.println("C for cash and CC for credit card");
            payment_option = reader.readLine();
            if (payment_option.equalsIgnoreCase("C")) {
                payment = new CashPayment();
                break;
            } else if (payment_option.equalsIgnoreCase("CC")) {
                String cardNumber;
                String CVV;
                String expiryDate;
                System.out.println("Enter card number: ");
                cardNumber = reader.readLine();
                System.out.println("Enter CVV: ");
                CVV = reader.readLine();
                System.out.println("Enter expiry date: ");
                expiryDate = reader.readLine();
                payment = new CreditCardPayment(cardNumber, CVV, expiryDate);
                break;

            } else {
                System.out.println("Invalid payment option");
            }

        }

        double priceShopped = cart.checkout(payment);
        System.out.println("Total price:  " + priceShopped);

        transactionDAOImpl.addTransaction(cart);
        cart.getCartProducts().clear();
        cart.getProductQuantity().clear();
        cart.getObservers().clear();
        cart.setCheckoutPrice(0.0);

        productcatalog.getProducts().clear();
    }

}
