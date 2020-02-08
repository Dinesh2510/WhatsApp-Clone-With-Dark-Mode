package com.demo.myapplication.Model;

public class Call {


    private int profilePic;
    private String name;
    private String time;
    private String type;

    public Call(int profilePic, String name, String time, String type) {
        this.profilePic = profilePic;
        this.name = name;
        this.time = time;
        this.type = type;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
