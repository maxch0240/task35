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


//        String url = "jdbc:mysql://localhost:3306/strings";
//        String username = "root";
//        String password = "1234";
//        Class.forName("com.mysql.jdbc.Driver");
//
//        File file = new File("D:\\JAVA\\task1.1\\files\\2.txt");
//        int allFields = count("D:\\JAVA\\task1.1\\files\\2.txt");
//        System.out.println("file: " + file.getName());
//
//
//        try (Connection conn = DriverManager.getConnection(url, username, password)) {
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        int counter = 0;
//
//        String line;
//        while ((line = reader.readLine()) != null) {
//        String[] arrSplit = line.split("\\|\\|");
//        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO strings VALUES (?, ?, ?, ?, ?);");
//        preparedStatement.setString(1, arrSplit[0]);
//        preparedStatement.setString(2, arrSplit[1]);
//        preparedStatement.setString(3, arrSplit[2]);
//        preparedStatement.setString(4, String.valueOf(Integer.parseInt(arrSplit[3])));
//        preparedStatement.setString(5, String.valueOf(Double.parseDouble(arrSplit[4])));
//        preparedStatement.executeUpdate();
//        counter++;
//        System.out.println("fields left: " + (allFields - counter));
//
//        }
//        reader.close();
//
