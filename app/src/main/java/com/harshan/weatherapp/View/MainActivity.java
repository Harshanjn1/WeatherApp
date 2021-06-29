package com.harshan.weatherapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.harshan.weatherapp.Model.WeatherData;
import com.harshan.weatherapp.R;
import com.harshan.weatherapp.ViewModel.WeatherViewmodel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtPlace, txtTemp, txtWeather;
    private EditText edtPlace;
    private Button btnGet;
    private ConstraintLayout mConstraintLayout;
    private WeatherViewmodel weatherViewmodel;
    private String weatherCondition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPlace = findViewById(R.id.txtPlace);
        txtTemp = findViewById(R.id.txtTemp);
        txtWeather = findViewById(R.id.txtWeather);
        edtPlace = findViewById(R.id.edtLocation);
        btnGet = findViewById(R.id.btnGet);
        mConstraintLayout = findViewById(R.id.mainLayout);
        weatherViewmodel = new ViewModelProvider(this).get(WeatherViewmodel.class);


        btnGet.setOnClickListener(MainActivity.this);
        getWeatherData(edtPlace.getText().toString());

    }


    @Override
    public void onClick(View v) {
        getWeatherData(edtPlace.getText().toString());
    }

  public void getWeatherData(String cityName) {
    weatherViewmodel.getmWeatherDataMutableLiveData(cityName).observe(MainActivity.this, new Observer<WeatherData>() {
        @Override
        public void onChanged(WeatherData weatherData) {
//            Log.i("mainactivity", weatherData.toString());
            txtPlace.setText(weatherData.getCity());
            txtTemp.setText(weatherData.getMain().getTemp() + " ℃");
            txtWeather.setText(weatherData.getWeather()[0].getMain());
            switch (weatherData.getWeather()[0].getMain()) {
                case "Clouds":
                    mConstraintLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.cloud));
                    break;

                case "Rain":
                    mConstraintLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.rain));
                    break;

                case "Clear":
                    mConstraintLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.clear));
                    break;

                case "Thunderstorm":
                    mConstraintLayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.lightning));
                    break;

            }
        }
    });
  }



}

