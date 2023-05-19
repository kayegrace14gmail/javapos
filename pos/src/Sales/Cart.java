/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales;

import Payment.CashPayment;
import Payment.CreditCardPayment;
import Payment.PaymentStrategy;
import decorator.ExpressShipping;
import decorator.GiftWrapping;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import persist.DBConnection;
import persist.ProductDAOImpl;
import products.Product;

public class Cart {

    private Cart(List<Product> currentProductList) {
        this.currentProductList = currentProductList;
    }

    // static instance of the class
    private static Cart instance;

    public static Cart getInstance(List<Product> currentProductList) {
        if (instance == null) {
            instance = new Cart(currentProductList);
        }
        return instance;
    }

    private List<CartObserver> observers = new ArrayList<>();
    private List<Product> productsShopped = new ArrayList<>();
    private List<Integer> quantityShopped = new ArrayList<>();
    List<Product> currentProductList;
    double totalPrice = 0.0;
    private String paymentOption;

    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CartObserver observer) {
        observers.remove(observer);
    }

    public List<CartObserver> getObservers() {
        return observers;
    }

    public void addProduct(Long productID, int quantity_taken, boolean giftwrapped, boolean express_shipped) throws SQLException, ClassNotFoundException {
        for (Product pdt : currentProductList) {
            if (Objects.equals(pdt.getProductID(), productID)) {
                if (giftwrapped) {
                    pdt = new GiftWrapping(pdt);
                }
                if (express_shipped) {
                    pdt = new ExpressShipping(pdt);
                }
                productsShopped.add(pdt);
                quantityShopped.add(quantity_taken);
                pdt.setQuantity(pdt.getQuantity() - quantity_taken);
                notifyObservers(pdt, quantity_taken);
            }
        }
    }

    private void notifyObservers(Product product, int quantityShopped) {
        for (CartObserver observer : observers) {
            observer.update(product, quantityShopped);
        }
    }

    public double checkout(PaymentStrategy payment) throws SQLException, ClassNotFoundException {

        for (int i = 0; i < productsShopped.size(); i++) {
            totalPrice += productsShopped.get(i).getPrice() * quantityShopped.get(i);
        }

        if (payment instanceof CashPayment) {
            this.paymentOption = "Cash";
        } else if (payment instanceof CreditCardPayment) {
            this.paymentOption = "Credit card";
        } else {
            throw new IllegalArgumentException();
        }

        if (payment.processPayment(totalPrice)) {
            //      updating the quantities of the products
            for (Product pdt : productsShopped) {
                ProductDAOImpl productDAOImpl = new ProductDAOImpl(DBConnection.accessConnection());
                productDAOImpl.updateProduct(pdt);
            }

            return totalPrice;

        } else {
            return 0.0;
        }
    }

    public double getCheckoutPrice() {
        return this.totalPrice;
    }

    public List<Product> getCartProducts() {
        return productsShopped;
    }

    public List<Integer> getProductQuantity() {
        return quantityShopped;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setCheckoutPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
