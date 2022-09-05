package com.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class AdminPanelController extends Util implements Initializable {
    @FXML
    private Button btnLogout;

    @FXML
    private Button btnViewCustomer;

    @FXML
    private Button btnViewOrder;

    @FXML
    private TableColumn<Order, Integer> colCustomerId;

    @FXML
    private TableColumn<Order, String> colFoodItem;

    @FXML
    private TableColumn<Order, Timestamp> colOrderDateTime;

    @FXML
    private TableColumn<Order, Integer> colOrderQuantity;

    @FXML
    private TableView<Order> tblOrder;

    @FXML
    private StackPane mainLayer;

    @FXML
    private AnchorPane viewCustomers;

    @FXML
    private AnchorPane viewOrder;

    @FXML
    private TableColumn<Customer, String> colAddress;

    @FXML
    private TableColumn<Customer, String> colContact;

    @FXML
    private TableColumn<Customer, Integer> colCusId;

    @FXML
    private TableColumn<Customer, String> colCustomerName;

    @FXML
    private TableView<Customer> tblCustomerDetails;

    public void switchPanel(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(event.getSource().equals(btnViewOrder)){
            mainLayer.getChildren().setAll(viewOrder);
        }else{
            mainLayer.getChildren().setAll(viewCustomers);
        }
    }

    public void logout() throws IOException {
        changeScene("mainDashboard.fxml", StartApp.getWindow());
    }

    public void getAllOrders() throws SQLException, ClassNotFoundException {
        DBAccess dba = new DBAccess();
        ObservableList<Order> orders = dba.findAllOrders();
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colOrderQuantity.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));
        colOrderDateTime.setCellValueFactory(new PropertyValueFactory<>("orderDateTime"));
        colFoodItem.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        tblOrder.setItems(orders);
    }

    public void getAllCustomers() throws SQLException, ClassNotFoundException {
        DBAccess dba = new DBAccess();
        ObservableList<Customer> customers = dba.findAllCustomer();
        colCusId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        tblCustomerDetails.setItems(customers);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getAllOrders();
            getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
