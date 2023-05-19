/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persist;

/**
 *
 * @author Kaye
 */
import products.Barcode;
import java.io.IOException;
import java.sql.*;
import products.BakeryProduct;
import products.BeverageProduct;
import products.ClothingProduct;
import products.CosmeticsProduct;
import products.ElectronicsProduct;
import products.GroceryProduct;
import products.Product;
import products.ProductCatalog;

public class ProductDAOImpl implements ProductDAO {

    private Connection connection;

    public ProductDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, description, price, quantity, category) VALUES (?, ?, ?, ?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getCategory());
            statement.executeUpdate();

            //getting id and using it to create barcode
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                long lastID = rs.getLong(1);
                try {
                    System.out.println("Product added successfully");
                    Barcode.generateBarcode(product.getName(), lastID);

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE products SET quantity = ? WHERE productID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getQuantity());
            statement.setLong(2, product.getProductID());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        }
    }

    @Override
    public Product getProductById(Long productID) throws SQLException {
        String sql = "SELECT * FROM products WHERE productID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, productID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String category = resultSet.getString("category");
                return switch (category) {
                    case "Bakery" ->
                        new BakeryProduct(
                        resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                        );
                    case "Beverage" ->
                        new BeverageProduct(
                        resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                        );
                    case "Clothing" ->
                        new ClothingProduct(
                        resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                        );
                    case "Cosmetics" ->
                        new CosmeticsProduct(
                        resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                        );
                    case "Electronics" ->
                        new ElectronicsProduct(
                        resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                        );
                    case "Grocery" ->
                        new GroceryProduct(
                        resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                        );
                    default ->
                        null;
                };

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void getAllProducts() throws SQLException {
//        List<Product> products = new ArrayList<>();

        ProductCatalog productcatalog = ProductCatalog.getInstance();
        String sql = "SELECT * FROM products";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            String category = resultSet.getString("category");
            switch (category) {
                case "Bakery" ->
                    productcatalog.addProduct(new BakeryProduct(
                            resultSet.getLong("productID"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getFloat("price"),
                            resultSet.getInt("quantity")
                    ));
                case "Beverage" ->
                    productcatalog.addProduct(new BeverageProduct(
                            resultSet.getLong("productID"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getDouble("price"),
                            resultSet.getInt("quantity")
                    ));
                case "Clothing" ->
                    productcatalog.addProduct(new ClothingProduct(
                            resultSet.getLong("productID"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getFloat("price"),
                            resultSet.getInt("quantity")
                    ));
                case "Cosmetics" ->
                    productcatalog.addProduct(new CosmeticsProduct(
                            resultSet.getLong("productID"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getFloat("price"),
                            resultSet.getInt("quantity")
                    ));
                case "Electronics" ->
                    productcatalog.addProduct(new ElectronicsProduct(
                            resultSet.getLong("productID"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getFloat("price"),
                            resultSet.getInt("quantity")
                    ));
                case "Grocery" ->
                    productcatalog.addProduct(new GroceryProduct(
                            resultSet.getLong("productID"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getFloat("price"),
                            resultSet.getInt("quantity")
                    ));
                default -> {
                    System.out.println("No products available yet");
                }
            }
        }

    }
}
