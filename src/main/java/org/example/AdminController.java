package org.example;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    /**
     * Este metodo establecera en los campos de texto los valores correspondientes de informacion sobre el usuario
     * ademas usa Eventos para modificar el CSS de algunos elementos
     */
    public void initialize() {
        label_nameText.setText(user.getUsername());
        label_dniText.setText(user.getDni());
        label_WPText.setText(user.getWP());

        label_nameText.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label_nameText.setStyle("-fx-border-color: black; -fx-background-color: #7fff00");
            }
        });
        label_WPText.setOnMouseEntered(event -> label_WPText.setStyle("-fx-border-color: black; -fx-background-color: #7fff00"));
        label_dniText.setOnMouseEntered(event -> label_dniText.setStyle("-fx-border-color: black; -fx-background-color: #7fff00"));
        label_nameText.setOnMouseExited(event -> label_nameText.setStyle("-fx-background-color: #7fff00; -fx-border-color: none"));
        label_WPText.setOnMouseExited(event -> label_WPText.setStyle("-fx-background-color: #7fff00; -fx-border-color: none"));
        label_dniText.setOnMouseExited(event -> label_dniText.setStyle("-fx-background-color: #7fff00; -fx-border-color: none"));
    }
    /**
     * Si se pulsa el boton Logout de la vista. Se redirigira al usuario a la vista Login
     * @throws IOException
     */
    @FXML
    public void LogOut() throws IOException {
        App.setRoot("login");
    }

    /**
     * Metodo usado para pasar el objeto usuario al controlador de la sesion iniciada
     * @param u
     */
    public static void setUser(User u){
        user=u;
    }
}
