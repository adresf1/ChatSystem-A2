package com.example.chatsystema2.Client;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.chatsystema2.Client.Core.ClientFactory;
import com.example.chatsystema2.Client.Core.ModelFactory;
import com.example.chatsystema2.Client.Core.ViewHandler;
import com.example.chatsystema2.Client.Core.ViewModelFactory;

public class ChatSystemApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}

