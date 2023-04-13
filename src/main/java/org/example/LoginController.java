package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;
import org.example.model.Admin;
import org.example.model.User;
import org.example.model.repoUsers;

public class LoginController{

    @FXML
    private TextField name_txt;
    @FXML
    private PasswordField passwd_txt;
    private User user;
    @FXML
    private Label label_error;

    /**
     * Este metodo se encarga de validar que los campos no esten vacios. si no lo estan se procede a intentar iniciar sesion
     * Si se aprueba el inicio de sesion se cambiara de escena
     * @throws IOException
     */
    @FXML
    private void userValidate() throws IOException{
        if(name_txt.getText().length()>0 && passwd_txt.getText().length()>0){
            if(login()){
                System.out.println(user.getClass());
                if(user instanceof Admin){
                    UserController.setUser(user);
                    App.setRoot("Admin");
                }else{
                    UserController.setUser(user);
                    App.setRoot("User");
                }
            }else{
                label_error.setText("Usuario o contraseña incorrecto");
            }
        }else{
            label_error.setText("Rellene los campos obligatorios");
        }
    }

    /**
     * Este metodo se encarga de validar si la contraseña y el usuario son los correctos
     * @return
     */
    private boolean login(){
        for (Object aux:repoUsers.get_instance().getUsers()){
            if(aux instanceof Admin){
                if(((Admin) aux).getUsername().equalsIgnoreCase(name_txt.getText()) && ((Admin) aux).login(name_txt.getText(),passwd_txt.getText())){
                    user=(Admin)aux;
                    return true;
                }
            }else{
                if(((User) aux).getUsername().equalsIgnoreCase(name_txt.getText()) && ((User) aux).login(name_txt.getText(),passwd_txt.getText())){
                    user=(User)aux;
                    return true;
                }
            }
        }
        return false;
    }


    @FXML
    private void signIn() throws IOException {
        App.setRoot("SignIn");
    }
}
