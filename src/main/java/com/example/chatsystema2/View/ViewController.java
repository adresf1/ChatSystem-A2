package com.example.chatsystema2.View;

import com.example.chatsystema2.Core.ViewHandler;
import com.example.chatsystema2.Core.ViewModelFactory;

public interface ViewController {
    public abstract void init(ViewHandler vh, ViewModelFactory vmf);
}
