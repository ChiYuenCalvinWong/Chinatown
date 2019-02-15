package com.example.calvin.chinatown;

public class Place {


    private String name;

    private static int c = 1;

    Place(){
        this.name = "place " + c;
        c++;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
