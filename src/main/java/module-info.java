module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    exports org.example;
    exports org.example.model;
    opens org.example.model to javafx.fxml, java.xml.bind;
    opens org.example to java.xml.bind, javafx.fxml;

}
