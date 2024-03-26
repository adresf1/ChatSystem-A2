package com.example.chatsystema2.Core;

import com.example.chatsystema2.View.ChatSystemClient.ChatSystemViewModel;

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
