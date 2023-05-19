/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author Kaye
 */
public class Pos {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        HeaderPrint.printHeader();
        String command;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OUTERM:
        while (true) {
            System.out.println("""
        =================================================================================================""");
            System.out.println("Enter command to continue:");
            System.out.printf("%-30s %10s", "Register new products:", "1");
            System.out.println("\n");
            System.out.printf("%-30s %10s", "Add to available stock", "2");
            System.out.println("\n");
            System.out.printf("%-30s %10s", "Search for product", "3");
            System.out.println("\n");
            System.out.printf("%-30s %10s", "Register transaction:", "4");
            System.out.println("\n");

            command = reader.readLine();
            switch (command) {
                case ">" -> {
                    System.out.println("Exiting program...................");
                    break OUTERM;
                }
                case "1" ->
                    Inventory.registerProduct();
                case "2" ->
                    Inventory.addStock();
                case "3" ->
                    Inventory.searchProduct();
                case "4" ->
                    Shopping.shopping();
                default ->
                    System.out.println("Unknown command");
            }
        }
    }
}
