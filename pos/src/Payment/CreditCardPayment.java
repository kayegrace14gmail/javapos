/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

/**
 *
 * @@author Kaye
 */
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String CVV;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String CVV, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.CVV = CVV;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid " + amount + " using credit card number " + cardNumber);
        return true;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}
