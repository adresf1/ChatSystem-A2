package com.example.chatsystema2.Model;


import com.example.chatsystema2.Network.Client;

import java.beans.PropertyChangeSupport;

public class ChatSystemManager implements ChatSystemModelInterface {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public ChatSystemManager(Client client) {
        this.client = client;
        //client.startClient();
        //client.addListener("NewLogEntry", this::onNewLogEntry);
    }

}
