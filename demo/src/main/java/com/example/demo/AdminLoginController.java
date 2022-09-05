package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLoginController {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    public void adminLogin(ActionEvent event) throws Exception {
        Login login = new Login(txtUsername.getText(), txtPassword.getText());
        AppController ap = new AppController();
        ap.handleLogin(login);
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    public void cancelLogin(ActionEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }
}

