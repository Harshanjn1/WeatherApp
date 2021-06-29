package com.harshan.weatherapp.Model;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main")
    private String main;


    public String getMain() {
        return main;
    }

    public void setId(String main) {
        this.main = main;
    }


}
