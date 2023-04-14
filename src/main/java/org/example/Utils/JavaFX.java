package org.example.Utils;

import javafx.scene.control.Alert;

public class JavaFX {

    public static void Warning(String msn){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msn);
        alert.showAndWait();
    }
}
