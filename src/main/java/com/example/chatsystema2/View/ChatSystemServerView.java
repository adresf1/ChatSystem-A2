package com.example.chatsystema2.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChatSystemServerView {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}