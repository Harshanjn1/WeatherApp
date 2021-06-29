package com.harshan.weatherapp.Services;

import com.harshan.weatherapp.Model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APICaller {
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    @GET("weather?appid=ef6a02c0061d09556a3130e466dd7ec1&units=metric")
    Call<WeatherData> getData(@Query("q") String name);
}
