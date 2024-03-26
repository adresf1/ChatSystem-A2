package com.example.chatsystema2.Network;

import java.beans.PropertyChangeSupport;

public class SocketClient implements Client{
    private PropertyChangeSupport support;

    public SocketClient() {
        support = new PropertyChangeSupport(this);
    }
}
