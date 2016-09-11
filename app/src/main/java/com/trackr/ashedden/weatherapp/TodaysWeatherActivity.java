package com.trackr.ashedden.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Allison on 9/10/2016.
 */

//Used direct lines of code from https://github.com/survivingwithandroid/Swa-app/tree/master/WeatherApp

public class TodaysWeatherActivity extends AppCompatActivity {

    static final String API_KEY = "71c9847a4dea7b8bf18c4c126f892abf";
    static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5";
    static final String API_WEATHER_URL = API_BASE_URL + "/weather?APPID=" + API_KEY + "&q=";

    Button fiveButton;
    String city;
    TextView cityName;
    TextView weatherDescription;
    TextView temperature;
    TextView humidty;
    TextView windSpeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todaysweather);

        //Retrieve city name from MainActivity
        city = getIntent().getStringExtra("city");

        cityName = (TextView) findViewById(R.id.citytext);
        weatherDescription = (TextView) findViewById(R.id.weathertext);
        temperature = (TextView) findViewById(R.id.temptext);
        humidty = (TextView)findViewById(R.id.humidtext);
        windSpeed = (TextView) findViewById(R.id.windtext);

        android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("");
        mActionBar  .setDisplayHomeAsUpEnabled(true);

        //Button is clicked, open TodaysWeatherActivity
        fiveButton = (Button) findViewById(R.id.today_button);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FiveDayActivity.class);
                i.putExtra("city",city);
                startActivity(i);
            }
        });

        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{city});
    }

    private class JSONWeatherTask extends AsyncTask<String, Void, WeatherModel> {

        @Override
        protected WeatherModel doInBackground(String... params) {
            WeatherModel weather = new WeatherModel();
            LocationModel loc = new LocationModel();

            HttpURLConnection con = null ;
            InputStream is = null;
            BufferedReader br = null;
            final String MY_URL = API_WEATHER_URL + city;

            try {
                con = (HttpURLConnection) ( new URL(MY_URL)).openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.connect();

                // Let's read the response
                StringBuffer buffer = new StringBuffer();
                is = con.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                String line = "";
                while (  (line = br.readLine()) != null ){
                    buffer.append(line + "\r\n");}
                Log.e("HELP", "Buffer.toString : " + buffer.toString());
                is.close();
                con.disconnect();

                // We create out JSONObject from the data
                JSONObject jObj = new JSONObject(buffer.toString());

                // We start extracting the info

                JSONObject sysObj = jObj.getJSONObject("sys");
                loc.setCountry(sysObj.getString("country"));
                loc.setCity(jObj.getString("name"));
                weather.location = loc;

                // We get weather info (This is an array)
                JSONArray jArr = jObj.getJSONArray("weather");

                // We use only the first value
                JSONObject JSONWeather = jArr.getJSONObject(0);
                weather.currentCondition.setDescr(JSONWeather.getString("description"));

                JSONObject mainObj = jObj.getJSONObject("main");
                weather.currentCondition.setHumidity(mainObj.getInt("humidity"));
                weather.temperature.setTemp((float)mainObj.getDouble("temp"));

                // Wind
                JSONObject wObj = jObj.getJSONObject("wind");
                weather.wind.setSpeed((float)wObj.getDouble("speed"));

                return weather;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch(Throwable t) {
                t.printStackTrace();
            }
            finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
            return weather;

    }

        @Override
        protected void onPostExecute(WeatherModel weather) {

            Log.e("HELP", "weather: "+ weather);

            cityName.setText(weather.location.getCity() + ", " + weather.location.getCountry());
            weatherDescription.setText(weather.currentCondition.getDescr());
            temperature.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + " °C");
            humidty.setText("" + weather.currentCondition.getHumidity() + "%");
            windSpeed.setText("" + weather.wind.getSpeed() + " mps");

            super.onPostExecute(weather);

        }

    }

    //From Android website
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
