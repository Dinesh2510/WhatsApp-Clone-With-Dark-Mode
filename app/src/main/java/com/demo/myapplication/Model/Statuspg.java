package com.demo.myapplication.Model;

public class Statuspg {
    int Status_Image;
    String Status_name;
    String Status_time;

    public Statuspg(int status_Image, String status_name, String status_time) {
        Status_Image = status_Image;
        Status_name = status_name;
        Status_time = status_time;
    }

    public int getStatus_Image() {
        return Status_Image;
    }

    public void setStatus_Image(int status_Image) {
        Status_Image = status_Image;
    }

    public String getStatus_name() {
        return Status_name;
    }

    public void setStatus_name(String status_name) {
        Status_name = status_name;
    }

    public String getStatus_time() {
        return Status_time;
    }

    public void setStatus_time(String status_time) {
        Status_time = status_time;
    }
}
