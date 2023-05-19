/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persist;

import java.sql.*;

/**
 *
 * @@author Kaye
 */
public class DBConnection {

    public static Connection accessConnection() throws ClassNotFoundException, SQLException {

        // Set up connection parameters
//        String url = "jdbc:mysql://http:///epiz_34062712_bse2313"; 

        String url = "jdbc:mysql://localhost:3306/pos";
        String user = "root";
        String password = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

}
