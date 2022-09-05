package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;

public class AppController extends Util{
    private DBAccess dba;

    public void handleLogin(Login login) throws Exception {
        dba = new DBAccess();
        String password = dba.login(login.getUsername());
        if(password != null){
            if(password.equals(login.getPassword())){
                changeScene("adminPanel.fxml", StartApp.getWindow());
            }else{
                errorDialog("Wrong password!!!");
            }
        }else{
            errorDialog("Wrong Username!!!");
        }
    }

    public boolean saveOrder(Order order, String foodId) throws SQLException, ClassNotFoundException, IOException {
        dba = new DBAccess();
        boolean isSet = false;
        int generatedOrderId = dba.saveOrder(order);
        if (generatedOrderId >= 1){
            if (dba.saveFoodOrder(new FoodOrder(foodId, generatedOrderId)) == 1){
                confirmDialog("Order Successful");
                isSet = true;
            }
        }else{
            errorDialog("Order Failed!!!");
        }
        return isSet;
    }

    public int saveCustomer(Customer customer) throws Exception{
        dba = new DBAccess();
        int generatedCustomerId = dba.saveCustomer(customer);
        if (generatedCustomerId >= 1){
//            confirmDialog("Order received Successful");
            return generatedCustomerId;
        }else{
            return 0;
        }
    }


}
