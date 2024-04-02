package com.example.chatsystema2.Client.Network;

import com.example.chatsystema2.Shared.TransferObject.Message;
import com.example.chatsystema2.Shared.Util.Subject;

import java.util.ArrayList;

public interface Client extends Subject{
    String sendMessage(String msg);
    ArrayList<Message> getGlobalChat();

    void startMsgClient();
}
