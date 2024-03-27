package com.example.chatsystema2.Model;

import com.example.chatsystema2.Shared.TransferObject.Message;

import java.util.ArrayList;

public interface ChatSystemModelInterface {
    String sendMessage(String msg);
    ArrayList<Message> getGlobalChat();
}
