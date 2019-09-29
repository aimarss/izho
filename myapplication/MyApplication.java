package com.example.myapplication;

import android.app.Application;

import java.util.List;

public class MyApplication extends Application {
    private List<Integer> ids;

    public void append(int id){
        ids.add(id);
    }

    public List<Integer> getIds(){
        return ids;
    }

}
