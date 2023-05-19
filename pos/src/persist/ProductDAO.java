/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persist;

import java.sql.SQLException;
import products.Product;

/**
 *
 * @@author Kaye
 */
public interface ProductDAO {
    public void getAllProducts() throws SQLException;
    public Product getProductById(Long productID) throws SQLException;
    public void addProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public void deleteProduct(int id) throws SQLException;
}
