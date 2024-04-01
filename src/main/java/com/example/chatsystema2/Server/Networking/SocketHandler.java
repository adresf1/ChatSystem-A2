package com.example.chatsystema2.Server.Networking;

import com.example.chatsystema2.Server.Model.ChatSystemModelInterface;
import com.example.chatsystema2.Shared.TransferObject.Message;
import com.example.chatsystema2.Shared.TransferObject.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SocketHandler implements Runnable {
    private Socket socket;
    private ChatSystemModelInterface chatSystemModelInterface;

    private ObjectInputStream inFromClient;

    private ObjectOutputStream outToClient;

    public SocketHandler(Socket socket, ChatSystemModelInterface chatSystemModelInterface) {
        this.socket = socket;
        this.chatSystemModelInterface = chatSystemModelInterface;

        try{
            inFromClient = new ObjectInputStream(socket.getInputStream());
            outToClient = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Request request = (Request) inFromClient.readObject();
            if("Listener".equals(request.getType())){
                chatSystemModelInterface.addListener("NewMessage",this::onNewMessage);
            } else if ("Message".equals(request.getType())) {
                String result = chatSystemModelInterface.sendMessage((String) request.getArg());
                outToClient.writeObject(new Request("Message", result));
            } else if ("GlobalChat".equals(request.getType())) {
                ArrayList<Message> chatLog = chatSystemModelInterface.getGlobalChat();
                outToClient.writeObject(new Request("GlobalChat",chatLog));
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void onNewMessage(PropertyChangeEvent propertyChangeEvent) {
        try{
            outToClient.writeObject(new Request(propertyChangeEvent.getPropertyName(), propertyChangeEvent.getNewValue()));
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
