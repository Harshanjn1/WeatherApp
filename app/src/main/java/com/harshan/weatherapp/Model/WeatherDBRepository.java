package com.harshan.weatherapp.Model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.harshan.weatherapp.Services.APICaller;
import com.harshan.weatherapp.Services.RetrofitProviderClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherDBRepository {
    private MutableLiveData<WeatherData> mWeatherData = new MutableLiveData<>();
    private static WeatherDBRepository mWeatherDBRepository;

    private WeatherDBRepository() {

    }

    public static WeatherDBRepository getInstance() {
        if (mWeatherDBRepository == null) {
            synchronized (WeatherDBRepository.class) {
                mWeatherDBRepository = new WeatherDBRepository();
            }
        }
        return mWeatherDBRepository;
    }

    public MutableLiveData<WeatherData> getWeatherDataFromAPI(String location) {
        Retrofit retrofit = RetrofitProviderClass.getRetrofitInstance(APICaller.BASE_URL);
        APICaller apiCaller = retrofit.create(APICaller.class);
        Call<WeatherData> weatherData = apiCaller.getData(location);
        weatherData.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call,
                                   Response<WeatherData> response) {
                if (response.isSuccessful()) {
                    Log.i("response", response.body() + "");
                    mWeatherData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<WeatherData> call,
                                  Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
        return mWeatherData;
    }
}
