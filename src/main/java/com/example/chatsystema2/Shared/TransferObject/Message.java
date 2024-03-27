package com.example.chatsystema2.Shared.TransferObject;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender, message;

    public Message(String sender, String message){
        this.message = message;
        this.sender = sender;
    }

    public String getSender(){return sender;}

    public String getMessage() {return message;}
}
