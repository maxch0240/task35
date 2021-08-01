import logic.DBHandler;
import logic.Parser;
import model.OrderItems;
import model.Orders;
import model.Products;

import java.io.*;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        List<Orders> ordersList = Parser.parseOrders("orders.csv");
        List<OrderItems> orderItemsList = Parser.parseOrderItems("order_items.csv");
        List<Products> productsList = Parser.parseProducts("products.csv");

        DBHandler dbHandler = new DBHandler("jdbc:mysql://localhost:3306/strings", "root", "1234");

        dbHandler.fillTableOrders(ordersList);
        dbHandler.fillTableOrderItems(orderItemsList);
        dbHandler.fillTableProducts(productsList);

    }
}
