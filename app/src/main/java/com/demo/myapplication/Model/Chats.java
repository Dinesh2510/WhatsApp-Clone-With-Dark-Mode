package com.demo.myapplication.Model;

public class Chats {
    private String name;
    private int image;
    private String lastMsg;
    private String lastMsgTime;

    public Chats(String name, int image, String lastMsg, String lastMsgTime) {
        this.name = name;
        this.image = image;
        this.lastMsg = lastMsg;
        this.lastMsgTime = lastMsgTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(String lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }
}
