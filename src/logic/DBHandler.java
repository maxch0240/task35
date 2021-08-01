package logic;

import model.OrderItems;
import model.Orders;
import model.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBHandler {
    public static Connection conn;

    public DBHandler(String url, String username, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("законнектило");
        } catch(SQLException e)
        {
            System.out.println("не прокатило");
            e.printStackTrace();
        }
    }

    public void fillTableOrders(List<Orders> ordersList) throws SQLException {
        for (Orders orders : ordersList) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO orders VALUES (?, ?);");

            preparedStatement.setString(1, orders.getId());
            preparedStatement.setString(2, orders.getDateTime());

            preparedStatement.executeUpdate();
        }
    }

    public void fillTableOrderItems(List<OrderItems> orderItemsList) throws SQLException {
        for (OrderItems orderItems : orderItemsList) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO order_items VALUES (?, ?, ?);");

            preparedStatement.setString(1, orderItems.getOrderId());
            preparedStatement.setString(2, orderItems.getProductId());
            preparedStatement.setInt(3, orderItems.getQuantity());

            preparedStatement.executeUpdate();
        }
    }

    public void fillTableProducts(List<Products> productsList) throws SQLException {
        for (Products products : productsList) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO products VALUES (?, ?, ?);");

            preparedStatement.setString(1, products.getId());
            preparedStatement.setString(2, products.getName());
            preparedStatement.setInt(3, products.getPricePerUnit());

            preparedStatement.executeUpdate();
        }
    }


//    for each day of the month, determine the product that brought the maximum profit.
//    As an answer, enter the NAME of the leader's product for the date 2021-01-21.
    public String sqlScript() {
        String result;
        return "";
    }
}
