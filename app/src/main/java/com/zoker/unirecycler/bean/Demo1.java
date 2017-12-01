package com.zoker.unirecycler.bean;

/**
 * Created by zoker on 2017/11/30.
 */

public class Demo1 {
    public String title = "Demo1";
    public int type = 1;

    public Demo1(){}
    public Demo1(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
