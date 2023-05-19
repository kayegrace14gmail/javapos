/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import products.Product;

public class Receipt {

    public double checkoutPrice;

    public void printReceipt(Cart currentcart, int transactionID, String date_time) {

        checkoutPrice = currentcart.getCheckoutPrice();
        // Generate filename with timestamp

        String filename = "Receipts/receipt_" + date_time + ".txt";

        // Open file for writing
        File file = new File(filename);

        try {
            FileWriter writer = new FileWriter(file);

            // Write header
            writer.write("========= KIKONI SHOPPERS =============\n");
            writer.write("         MAKERERE KIKONI\n");
            writer.write("Date: " + new Date() + "\n");
            writer.write("Transaction ID:             " + transactionID);
            writer.write("\n");
            writer.write("Payment method:           " + currentcart.getPaymentOption());
            writer.write("\n");
            writer.write("---------------------------------------------");
            writer.write("\n");
            writer.write(String.format("%-27s%-12s%-10s%n", "Item", "Quantity", "Price"));

            // Write cart items
            List<Product> items = currentcart.getCartProducts();
            List<Integer> quantityShopped = currentcart.getProductQuantity();

            for (int j = 0; j < items.size(); j++) {

                writer.write(String.format("%-30s%-7s%-10s%n",
                        items.get(j).getName(),
                        quantityShopped.get(j),
                        items.get(j).getPrice()));
            }

            writer.write("\n");
            writer.write("---------------------------------------------");
            writer.write("\n");

            // Write total price
            writer.write(String.format("%-30s%-10s%n", "Total price: ", checkoutPrice + "\n\n"));

            writer.write("************************************************\n");
            writer.write("        (G)- Gift Wrapping - 2000\n");
            writer.write("       (E)- Express Shipping - 3000\n");
            writer.write("      Goods once sold are not returnable\n");
            writer.write("          THANK YOU FOR CHOOSING US\n");

            // Close file
            writer.close();

            System.out.println("Receipt saved to file: " + filename + "\n");

        } catch (IOException e) {
            System.out.println("Failed to print receipt: " + e.getMessage());
        }
    }

}
