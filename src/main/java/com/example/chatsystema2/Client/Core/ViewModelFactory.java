package com.example.chatsystema2.Client.Core;

import com.example.chatsystema2.Client.View.ChatSystemClient.ChatSystemViewModel;

public class ViewModelFactory {
    private final ModelFactory mf;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public ChatSystemViewModel getChatSystemVM(){
        return null;
    }

    //public LogViewModel getLogViewModel(){}
}
