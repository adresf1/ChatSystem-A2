package com.example.chatsystema2.Client.Core;

import com.example.chatsystema2.Client.Model.ChatSystemManager;
import com.example.chatsystema2.Client.Model.ChatSystemModelInterface;
public class ModelFactory {

    private final ClientFactory cf;
    private ChatSystemModelInterface ChatSystemModel;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
        //TODO: why does this not need getInstance function - possible error?
    }

    public ChatSystemModelInterface getChatSystemModel() {
        if(ChatSystemModel == null)
            ChatSystemModel = new ChatSystemManager(cf.getClient());
        return ChatSystemModel;
    }
}
