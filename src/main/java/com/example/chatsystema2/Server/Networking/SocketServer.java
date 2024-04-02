package com.example.chatsystema2.Server.Networking;

import com.example.chatsystema2.Server.Model.ChatSystemModelInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ChatSystemModelInterface chatSystemModelInterface;

    public SocketServer(ChatSystemModelInterface chatSystemModelInterface) {
        this.chatSystemModelInterface = chatSystemModelInterface;
    }

    public void startServer(){
        try{
            ServerSocket welcome = new ServerSocket(2910);

            while(true){
                Socket socket = welcome.accept();

                //todo stat thread
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
