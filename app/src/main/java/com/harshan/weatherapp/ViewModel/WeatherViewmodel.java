package com.harshan.weatherapp.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.harshan.weatherapp.Model.WeatherDBRepository;
import com.harshan.weatherapp.Model.WeatherData;
import com.harshan.weatherapp.Services.APICaller;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewmodel extends ViewModel{

    private MutableLiveData<WeatherData> mWeatherDataMutableLiveData = new MutableLiveData<>();
    private WeatherDBRepository mWeatherDBRepository;

    public  MutableLiveData<WeatherData> getmWeatherDataMutableLiveData(String location) {
        mWeatherDBRepository = WeatherDBRepository.getInstance();
        mWeatherDataMutableLiveData = mWeatherDBRepository.getWeatherDataFromAPI(location);
        return mWeatherDataMutableLiveData;
    }
}
