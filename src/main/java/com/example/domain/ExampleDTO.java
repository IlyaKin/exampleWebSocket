package com.example.domain;

public class ExampleDTO {

    private String message;
    private int time;



    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(int time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public int getTimestamp() {
        return time;
    }


    public ExampleDTO(int time, String message) {
        this.message = message;
        this.time = time;

    }
}
