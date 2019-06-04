package com.example.youyi.trafficlightmanagement2;


public class Road {
    private Integer number;
    private Integer red;
    private Integer yellow;
    private Integer green;

    public Road(Integer number,Integer red,Integer yellow,Integer green){
        this.green = green;
        this.yellow = yellow;
        this.number = number;
        this.red = red;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Integer getYellow() {
        return yellow;
    }

    public void setYellow(Integer yellow) {
        this.yellow = yellow;
    }

    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }
}

