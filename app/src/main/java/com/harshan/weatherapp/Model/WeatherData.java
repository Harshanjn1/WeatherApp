package com.harshan.weatherapp.Model;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    @SerializedName("name")
    private String city;
    @SerializedName("weather")
    private Weather[] weather;
    @SerializedName("main")
    private Main main;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
