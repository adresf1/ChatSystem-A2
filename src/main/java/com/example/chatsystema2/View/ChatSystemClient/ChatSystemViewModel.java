package com.example.chatsystema2.View.ChatSystemClient;

import com.example.chatsystema2.Model.ChatSystemManager;
import com.example.chatsystema2.Shared.TransferObject.Message;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.example.chatsystema2.Model.ChatSystemModelInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ChatSystemViewModel {

    private ObservableList<Message> globalChat;
    //private StringProperty reply;
    private ChatSystemModelInterface chatSystemModelInterface;

    public ChatSystemViewModel(ChatSystemModelInterface chatSystemModelInterface) {
        this.chatSystemModelInterface = chatSystemModelInterface;
        this.globalChat = FXCollections.observableArrayList();
    }

    public void loadGlobalChat(){
        ArrayList<Message> globalChatLog = chatSystemModelInterface.getGlobalChat();
    }

    public ObservableList<Message> getCGlobalChatLog(){return globalChat;}
}
