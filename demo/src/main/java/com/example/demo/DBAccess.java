package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.sql.*;

public class DBAccess {
    private final String DB_NAME = "mydb";
    private final String USER = "root";
    private final String BDCONNECTION = "com.mysql.cj.jdbc.Driver";
    private final String PASSWORD = "";
    private final String HOST = "localhost";
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;


    public DBAccess() throws SQLException, ClassNotFoundException {
        Class.forName(BDCONNECTION);
        con = DriverManager.getConnection(getUrl());
    }

    private String getUrl(){
        return "jdbc:mysql://"+USER+":"+PASSWORD+"@"+HOST+"/"+DB_NAME;
    }


//    <-------------Saving Entities into the database -------------->

    public int saveCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO customer VALUE (null, ?, ?, ?)";
        pst = con.prepareStatement(query, pst.RETURN_GENERATED_KEYS);
        pst.setString(1, customer.getCustomerName());
        pst.setString(2, customer.getCustomerPhone());
        pst.setString(3, customer.getCustomerAddress());
        if(pst.executeUpdate() == 1){
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
            else
                return 0;
        }else {
            return 0;
        }
    }

    public int saveOrder(Order order) throws SQLException {
        String query = "INSERT INTO mydb.order VALUE (null, ?, ?, ?, ?);";
        pst = con.prepareStatement(query, pst.RETURN_GENERATED_KEYS);
        pst.setInt(1, order.getCustomerId());
        pst.setDouble(2, order.getOrderQuantity());
        pst.setTimestamp(3, order.getOrderDateTime());
        pst.setInt(4, order.getOrderStatus());
        if(pst.executeUpdate() == 1){
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
            else
                return 0;
        }else {
            return 0;
        }
    }

    public int saveFood(Food food) throws SQLException {
        String query = "INSERT INTO food VALUE (?, ?, ?)";
        pst = con.prepareStatement(query);
        pst.setString(1, food.getFoodId());
        pst.setString(2, food.getFoodName());
        pst.setDouble(3, food.getFoodUnitPrice());
        return pst.executeUpdate();
    }

    public int saveFoodOrder(FoodOrder foodOrder) throws SQLException {
        pst = con.prepareStatement("INSERT INTO food_order VALUE (null, ?, ?)");
        pst.setString(1, foodOrder.getFoodId());
        pst.setInt(2, foodOrder.getOrderId());
        return pst.executeUpdate();
    }


//    <-------------End of Saving Entities into the database -------------->


//    <--------------- Login handler ------------------->
    public String login(String username) throws SQLException {
        String query = "SELECT password FROM login WHERE username = ? limit 1";
        pst = con.prepareStatement(query);
        pst.setString(1, username);
        rs = pst.executeQuery();
        if (rs.next()){
            return rs.getString("password");
        }else{
            return null;
        }
    }
//    <--------------- end of Login handler ------------------->


//    <---------------retrieving entities from the database ------------------->

    public ObservableList<Customer> findAllCustomer() throws SQLException {
        String query = "SELECT * FROM customer";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        return getAllCustomer();
    }
    private ObservableList<Customer> getAllCustomer() throws SQLException {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setCustomerName(rs.getString("name"));
            customer.setCustomerPhone(rs.getString("phone"));
            customer.setCustomerAddress(rs.getString("address"));
            customers.add(customer);
        }
        return customers;
    }


    public ObservableList<Order> findAllOrders() throws SQLException {
        String query = "SELECT * FROM mydb.order JOIN food_order ON order.order_id = food_order.order_id JOIN food ON food.food_id = food_order.food_id";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        return getAllOrders();
    }
    private ObservableList<Order> getAllOrders() throws SQLException {
        ObservableList<Order> orders = FXCollections.observableArrayList();
        while (rs.next()){
            Order order = new Order();
            order.setOrderQuantity(rs.getInt("order_quantity"));
            order.setOrderDateTime(rs.getTimestamp("order_date_time"));
            order.setCustomerId(rs.getInt("customer_id"));
            order.setFoodName(rs.getString("food.name"));
            orders.add(order);
        }
        return orders;
    }


//    <---------------end of retrieving entities from the database ------------------->


//    <---------------updating entities from the database ------------------->

    public int updateOrderStatus(Order order) throws SQLException {
        pst = con.prepareStatement("UPDATE order set order_status = ?");
        pst.setInt(1, 1);
        return pst.executeUpdate();
    }

//    <---------------end of updating entities from the database ------------------->


//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        new DBAccess();
//    }
}
