package com.example.chatsystema2.Core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.chatsystema2.View.ViewController;

import java.io.IOException;

public class ViewHandler {

    private Scene ChatSystemClientScene;
    private Stage stage;
    private ViewModelFactory vmf;
    private Scene logScene;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openChatSystemView();
    }

    public void openChatSystemView(){
        if (ChatSystemClientScene == null) {
            try {
                Parent root = loadFXML("../View/ChatSystemClient/ChatSystemClientView.fxml");

                stage.setTitle("Chat System Client");
                ChatSystemClientScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(ChatSystemClientScene);
        stage.show();
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }
    public void openLog(){

    }
}
