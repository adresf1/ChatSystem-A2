package com.example.chatsystema2.View.ChatSystemClient;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.example.chatsystema2.Model.ChatSystemModelInterface;
public class ChatSystemViewModel {
    private StringProperty reply;
    private ChatSystemModelInterface chatSystemModelInterface;

    public ChatSystemViewModel(ChatSystemModelInterface chatSystemModelInterface) {
        this.chatSystemModelInterface = chatSystemModelInterface;
        this.reply = new SimpleStringProperty();
    }
}
