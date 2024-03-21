module com.example.chatsystema2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatsystema2 to javafx.fxml;
    exports com.example.chatsystema2;
}