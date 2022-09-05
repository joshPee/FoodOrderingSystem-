package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.util.Date;

public class UserDetailWindowController {
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtContact;
    @FXML
    private TextField txtAddress;
    @FXML
    private Button btnDone;
    @FXML
    private Button btnCancel;

    public void addCustomer(ActionEvent event) throws Exception {
        AppController ap = new AppController();
        Customer customer = new Customer(txtFullName.getText(), txtContact.getText(), txtAddress.getText());
        int generatedCustomerId = ap.saveCustomer(customer);
        Order order = new Order(generatedCustomerId, QuantityController.getQuantity(), new Timestamp(new Date().getTime()), 0);
        if(ap.saveOrder(order, MainDashboardController.getFoodId())){
            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
        }
    }

    public void cancelDetailWindow(ActionEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }
}
