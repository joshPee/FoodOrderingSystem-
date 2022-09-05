package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QuantityController {
    @FXML
    private TextField txtQuantity;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnCancel;

    private static int quantity;

    public void setQuantity(ActionEvent event){
        try {
            quantity = Integer.parseInt(txtQuantity.getText());
            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Enter valid number!!");
        }
    }

    public void cancelQuantity(ActionEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    public static int getQuantity() {
        return quantity;
    }
}
