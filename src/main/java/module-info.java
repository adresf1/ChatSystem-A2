module com.example.chatsystema2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.chatsystema2 to javafx.fxml;
    exports com.example.chatsystema2.Client;
    exports com.example.chatsystema2.Client.View;
    opens com.example.chatsystema2.Client.View to javafx.fxml;
    opens com.example.chatsystema2.Client to javafx.fxml;
}