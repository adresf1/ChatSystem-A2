package com.example.chatsystema2;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.chatsystema2.Core.ClientFactory;
import com.example.chatsystema2.Core.ModelFactory;
import com.example.chatsystema2.Core.ViewHandler;
import com.example.chatsystema2.Core.ViewModelFactory;

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

