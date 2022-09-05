package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardController extends Util implements Initializable {
    @FXML
    private Button btnAdd1;
    @FXML
    private Button btnAdd2;
    @FXML
    private Button btnAdd3;
    @FXML
    private Button btnAdd4;
    @FXML
    private Button btnAdd5;
    @FXML
    private Button btnAdd6;
    @FXML
    private Button btnLogin;

    private static String foodId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
//
//    private static ArrayList<Order> orders;
//    private static ArrayList<Food> foods;
//
//    private ArrayList<Order> addToOrder(int quantity){
//        Order order = new Order(0 , quantity, new Timestamp(new Date().getTime()), 0);
//        orders = new ArrayList<>();
//        orders.add(order);
//        return orders;
//    }
//
//    private ArrayList<Food> addFoodToOder(FOODENUM foodID){
//        Food food = new Food();
//        food.setFoodId(foodID.toString());
//        foods = new ArrayList<>();
//        foods.add(food);
//        return foods;
//    }

    @FXML
    private void setOnAddClick(ActionEvent event) throws IOException {
        changeScene("quantity.fxml", new Stage());
        if (event.getSource().equals(btnAdd1))
            foodId = FOODENUM.W001.name();
        else if (event.getSource().equals(btnAdd2))
            foodId = FOODENUM.B001.name();
        else if(event.getSource().equals(btnAdd3))
            foodId = FOODENUM.B002.name();
        else if(event.getSource().equals(btnAdd4))
            foodId = FOODENUM.P001.toString();
        else if (event.getSource().equals(btnAdd5))
            foodId = FOODENUM.J001.name();
        else if(event.getSource().equals(btnAdd6))
            foodId = FOODENUM.P002.name();
    }

    public static String getFoodId() {
        return foodId;
    }

    public void onBtnConfirmClick() throws IOException {
        changeScene("userDetailwindow.fxml", new Stage());
    }

    public void onBtnLoginClick() throws IOException {
        changeScene("adminLogins.fxml", new Stage());
    }
}
