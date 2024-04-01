package com.example.chatsystema2.Client.Model;


import com.example.chatsystema2.Client.Network.Client;
import com.example.chatsystema2.Shared.TransferObject.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ChatSystemManager implements ChatSystemModelInterface {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public ChatSystemManager(Client client) {
        this.client = client;
        client.startMsgClient();
        client.addListener("NewMessage", this::onNewMessage);
    }

    private void onNewMessage(PropertyChangeEvent evt){
        support.firePropertyChange(evt);
    }
    @Override
    public String sendMessage(String msg) {
        return client.sendMessage(msg);
    }

    @Override
    public ArrayList<Message> getGlobalChat() {
        return client.getGlobalChat();
    }
}
