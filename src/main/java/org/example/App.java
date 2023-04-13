package org.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.Utils.XMLManager;
import org.example.model.*;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        this.stage.setTitle("Login App");
        scene = new Scene(loadFXML("login"), 705, 540);
        this.stage.setScene(scene);
        this.stage.show();
    }
    public static void setRoot(String nameScene) throws IOException {
        scene.setRoot(loadFXML(nameScene));
        stage.setScene(scene);
        stage.show();
    }
    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        repoUsers.set_instance(XMLManager.readXML(repoUsers.get_instance(),"Users.xml"));
        /*repoUsers.get_instance().addUser(new Admin("admin","admin","12345678Z","Teacher"));
        repoUsers.get_instance().addUser(new User("user","user","12367423M","Software developer"));*/
        launch();
        XMLManager.writeXML(repoUsers.get_instance(),"Users.xml");
    }

}