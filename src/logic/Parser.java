package logic;

import model.OrderItems;
import model.Orders;
import model.Products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    public static List<Orders> parseOrders (String fileName) {
        LinkedList<Orders> ordersList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ordersList.add(new Orders(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ordersList;
    }

    public static List<OrderItems> parseOrderItems (String fileName) {
        LinkedList<OrderItems> orderItemsList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                orderItemsList.add(new OrderItems(values[0], values[1], Integer.parseInt(values[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderItemsList;
    }

    public static List<Products> parseProducts (String fileName) {
        LinkedList<Products> productsList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                productsList.add(new Products(values[0], values[1], Integer.parseInt(values[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productsList;
    }
}

