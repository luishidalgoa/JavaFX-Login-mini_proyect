package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.model.User;

import java.io.IOException;

public class AdminController{
    @FXML
    private Button LogOut;
    @FXML
    private Label label_nameText;
    @FXML
    private Label label_dniText;
    @FXML
    private Label label_WPText;
    private static User user;
    //ME GUSTARIA CONOCER ALGUNA MANERA DE QUE AL PASAR DE ESCENARIO SE PASE POR PARAMETRO EL USUARIO QUE ES
    public void initialize() {
        label_nameText.setText(user.getUsername());
        label_dniText.setText(user.getDni());
        label_WPText.setText(user.getWP());
    }
    @FXML
    public void LogOut() throws IOException {
        App.setRoot("login");
    }

    public static void setUser(User u){
        user=u;
    }
}
