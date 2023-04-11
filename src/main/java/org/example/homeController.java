package org.example;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Utils.XMLManager;
import org.example.model.User;
import org.example.model.repoUsers;

public class homeController {

    @FXML
    private Button btn_home;
    @FXML
    private Label label_text;
    @FXML
    private void btnHomeValidate() throws IOException{
        if(label_text.getText().equals("Hola")){
            btn_home.setText("ADIOS");
        }
        label_text.setText("Hola");
    }

    @FXML
    private TextField name_txt;
    @FXML
    private TextField passwd_txt;
    private repoUsers users= XMLManager.readXML(repoUsers.get_instance(),"Users");
    @FXML Label label_error;
    @FXML
    private void userValidate() throws IOException{
        if(name_txt.getText().length()>0 && passwd_txt.getText().length()>0){
            login();
        }else{
            label_error.setText("Rellene los campos obligatorios");
        }
    }
    @FXML
    private boolean login(){
        for (User aux:repoUsers.get_instance().getUsers()){
            if(aux.getUsername().equals(name_txt.getText()) && aux.login(name_txt.getText(),passwd_txt.getText())){
                System.out.println("OK. SE INICIO");
                return true;
            }
        }
        System.out.println("Usuario o contraseña incorrecto");
        label_error.setText("Usuario o contraseña incorrecto");
        return false;
    }

}
