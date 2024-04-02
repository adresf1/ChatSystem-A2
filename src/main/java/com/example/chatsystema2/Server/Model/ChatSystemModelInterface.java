package com.example.chatsystema2.Server.Model;

import com.example.chatsystema2.Shared.TransferObject.Message;
import com.example.chatsystema2.Shared.Util.Subject;

import java.util.ArrayList;

public interface ChatSystemModelInterface extends Subject {
    public String sendMessage(String msg);
    public ArrayList<Message> getGlobalChat();

}
