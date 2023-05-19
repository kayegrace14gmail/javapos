/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

/**
 *
 * @@author Kaye
 */
public class CashPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid " + amount + " using cash.\n");
        return true;
    }
}
