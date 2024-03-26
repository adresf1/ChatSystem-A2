package com.example.chatsystema2.Core;

import com.example.chatsystema2.Network.Client;
import com.example.chatsystema2.Network.SocketClient;


import java.security.PrivateKey;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//package socketsuppercase.client.core;
//import com.example.chatsystema2.Network.Client;
//import socketsuppercase.client.network.SocketClient;

public class ClientFactory {
    private Client client;
    private static ClientFactory instance;
    private static final Lock lock = new ReentrantLock(){};

    //TODO: does this uphold singleton principle?
    //private ClientFactory(){};
    public ClientFactory(){};

    public static ClientFactory getInstance(){
        if(instance == null){
            synchronized (lock){
                if(instance==null){
                    instance = new ClientFactory();
                }
            }
        }
        return instance;
    }

    public Client getClient() {
        if(client == null) {
            client = new SocketClient();
        }
        return client;
    }
}