package com.example.chatsystema2.Client.Network;

import com.example.chatsystema2.Shared.TransferObject.Message;
import com.example.chatsystema2.Shared.TransferObject.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SocketClient implements Client{
    private PropertyChangeSupport support;

    public SocketClient() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }

    @Override
    public String sendMessage(String msg) {
        try {
            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer.writeObject(new Request("Message", msg));
            Request response = (Request) inFromServer.readObject();
            return (String) response.getArg();

        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return "Error in message sendMessage";
    }

    @Override
    public ArrayList<Message> getGlobalChat() {
        try {
            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer.writeObject(new Request("GlobalChat",null));
            Request response = (Request) inFromServer.readObject();
            return (ArrayList<Message>) response.getArg();

        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void startMsgClient() {
        try {
            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            new Thread(()->listenToServer(outToServer,inFromServer)).start();


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer){
        try {
            outToServer.writeObject(new Request("Listener",null));
            while(true){
                Request request = (Request) inFromServer.readObject();
                support.firePropertyChange(request.getType(), null, request.getArg());
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
