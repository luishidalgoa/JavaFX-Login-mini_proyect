package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.model.User;
import org.example.model.repoUsers;

import java.io.IOException;

public class SigninController{
    @FXML
    private TextField label_name;
    @FXML
    private PasswordField label_password;
    @FXML
    private TextField label_dni;
    @FXML
    private TextField label_WP;
    @FXML
    private Label label_error;

    /**
     * Se validan todos los campos y si no existe el usuario se procede a registrar el usuario
     * @throws IOException
     */
    @FXML
    public void SignIn() throws IOException {
        if(label_name.getText().length()>0 && label_password.getText().length()>0 && label_dni.getText().length()>0 && label_WP.getText().length()>0){
            if(repoUsers.get_instance().addUser(new User(label_name.getText(),label_password.getText(),label_dni.getText(),label_WP.getText()))){
                App.setRoot("login");
            }else{
                label_error.setText("Este usuario ya existe");
            }
        }else{
            label_error.setText("Rellene todos los campos");
        }
    }
    @FXML
    private void login() throws IOException {
        App.setRoot("login");
    }
}
