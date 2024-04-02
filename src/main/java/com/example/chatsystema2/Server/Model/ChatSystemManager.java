package com.example.chatsystema2.Server.Model;

import com.example.chatsystema2.Server.Model.ChatSystemModelInterface;
import com.example.chatsystema2.Shared.TransferObject.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ChatSystemManager implements ChatSystemModelInterface {
    private PropertyChangeSupport support;
    private ArrayList<Message> msgLog;

    public ChatSystemManager() {
        this.support = new PropertyChangeSupport(this);
        this.msgLog = new ArrayList<>();
    }

    @Override
    public String sendMessage(String msg) {
        Message msgToSend = new Message("Anonymous", msg);
        msgLog.add(msgToSend);
        support.firePropertyChange("NewMessage", null, msgToSend);
        return msg;
    }

    @Override
    public ArrayList<Message> getGlobalChat() {
        return new ArrayList<>(msgLog);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
