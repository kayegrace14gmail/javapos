/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persist;

import Sales.Cart;
import Sales.Receipt;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import products.Product;

/**
 *
 * @author Kaye
 */
public class TransactionDAOImpl {

    private Connection connection;

    public TransactionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void addTransaction(Cart currentcart) {

        String add_to_transaction_table = "INSERT INTO transactions (amount, date_time) VALUES (?, ?)";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        
        String transactionTime = dateFormat.format(new Date());
        
        int lastTransactionID;

        List<Product> items = currentcart.getCartProducts();
        List<Integer> quantityShopped = currentcart.getProductQuantity();

        try {
            PreparedStatement statement = connection.prepareStatement(add_to_transaction_table, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, currentcart.getCheckoutPrice());
            statement.setString(2, transactionTime);
            statement.executeUpdate();

//            statement.setDouble(3, product.getPrice());
//            statement.setInt(4, product.getQuantity());
//            statement.setString(5, product.getCategory());
//            
//          get the recent transaction ID from the trnsactions table
            ResultSet rs = statement.getGeneratedKeys();

                if(rs.next()) {
                    lastTransactionID = rs.getInt(1);
                    
                    //            write to the transactions_quantity table
            for (int j = 0; j < items.size(); j++) {
                String add_to_transaction_quantity_table = "INSERT INTO transaction_quantity (transactionID, productID, quantity) VALUES (?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(add_to_transaction_quantity_table); 
                stmt.setInt(1,lastTransactionID);
                stmt.setLong(2,items.get(j).getProductID());
                stmt.setInt(3, quantityShopped.get(j));
                stmt.executeUpdate();
        }
            
            Receipt receipt = new Receipt();
            receipt.printReceipt(currentcart, lastTransactionID, transactionTime);
                }
                 
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
}
