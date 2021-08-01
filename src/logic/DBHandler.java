package logic;

import model.OrderItems;
import model.Orders;
import model.Products;

import java.sql.*;
import java.util.List;

public class DBHandler {
    public static Connection conn;

    public DBHandler(String url, String username, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearUpTables() throws SQLException {
        Statement st = conn.createStatement();
        String sql1 = "truncate table orders;";
        String sql2 = "truncate table order_items;";
        String sql3 = "truncate table products;";

        st.executeUpdate(sql1);
        st.executeUpdate(sql2);
        st.executeUpdate(sql3);
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
    public String sqlQuery() throws SQLException {
        String result;
        String query = "select p.name from orders as o \n" +
                "inner join order_items as oi on o.id = oi.order_id\n" +
                "inner join products as p on oi.product_id = p.id\n" +
                "where date_format(o.date_time, '%Y-%m-%d') = '2021-01-21'\n" +
                "group by dayofmonth(o.date_time)\n" +
                "order by max(oi.quantity * p.price_per_unit) desc\n" +
                "limit 1;";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        result = resultSet.getString(1);

        return result;
    }
}
