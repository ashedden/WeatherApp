package com.trackr.ashedden.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Allison on 9/10/2016.
 */

//Used direct lines of code from https://github.com/survivingwithandroid/Swa-app/tree/master/WeatherApp

public class FiveDayActivity extends AppCompatActivity {

    static final String API_KEY = "71c9847a4dea7b8bf18c4c126f892abf";
    static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5";
    static final String API_FORECAST_URL = API_BASE_URL + "/forecast/daily?APPID=" + API_KEY;

    private final static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    String city;
    TextView date1, date2, date3, date4, date5;
    TextView weatherDescription1, weatherDescription2, weatherDescription3, weatherDescription4, weatherDescription5;
    TextView temperature1, temperature2, temperature3, temperature4, temperature5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiveday);

        //Retrieve city name from MainActivity
        city = getIntent().getStringExtra("city");

        date1 = (TextView) findViewById(R.id.five_date1);
        date2 = (TextView) findViewById(R.id.five_date2);
        date3 = (TextView) findViewById(R.id.five_date3);
        date4 = (TextView) findViewById(R.id.five_date4);
        date5 = (TextView) findViewById(R.id.five_date5);

        weatherDescription1 = (TextView) findViewById(R.id.five_weather1);
        weatherDescription2 = (TextView) findViewById(R.id.five_weather2);
        weatherDescription3 = (TextView) findViewById(R.id.five_weather3);
        weatherDescription4 = (TextView) findViewById(R.id.five_weather4);
        weatherDescription5 = (TextView) findViewById(R.id.five_weather5);

        temperature1 = (TextView) findViewById(R.id.five_temp1);
        temperature2 = (TextView) findViewById(R.id.five_temp2);
        temperature3 = (TextView) findViewById(R.id.five_temp3);
        temperature4 = (TextView) findViewById(R.id.five_temp4);
        temperature5 = (TextView) findViewById(R.id.five_temp5);

        android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("");
        mActionBar  .setDisplayHomeAsUpEnabled(true);

        JSONForecastWeatherTask task1 = new JSONForecastWeatherTask();
        task1.execute(new String[]{city});
    }

    private class JSONForecastWeatherTask extends AsyncTask<String, Void, ForecastModel> {

        @Override
        protected ForecastModel doInBackground(String... params) {
            ForecastModel forecast = new ForecastModel();

            HttpURLConnection con = null ;
            InputStream is = null;
            BufferedReader br1 = null;
            int forecastDayNum = 1;
            final String url = API_FORECAST_URL + "&cnt=5" + forecastDayNum + "&q=" + city;

            try {
                con = (HttpURLConnection) ( new URL(url)).openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);
                con.setDoOutput(true);
                con.connect();

                // Let's read the response
                StringBuffer buffer1 = new StringBuffer();
                is = con.getInputStream();
                br1 = new BufferedReader(new InputStreamReader(is));
                String line1 = "";
                while (  (line1 = br1.readLine()) != null )
                    buffer1.append(line1 + "\r\n");
                is.close();
                con.disconnect();

                // We create out JSONObject from the data
                JSONObject jObj = new JSONObject(buffer1.toString());

                JSONArray jArr = jObj.getJSONArray("list");

                for(int i=0;i<jArr.length()-2;i++) {
                    JSONObject wObj = jArr.getJSONObject(i);

                    if (i == 0) {
                        JSONObject tempObj = wObj.getJSONObject("temp");
                        forecast.temperature.setTemp1((float) tempObj.getDouble("day"));
                        JSONArray weatherjArr = wObj.getJSONArray("weather");

                        for (int j = 0; j < weatherjArr.length(); j++) {
                            JSONObject dObj = weatherjArr.getJSONObject(j);
                            forecast.currentCondition.setDescr1(dObj.getString("description"));
                        }
                    }
                    if (i == 1) {
                        JSONObject tempObj = wObj.getJSONObject("temp");
                        forecast.temperature.setTemp2((float) tempObj.getDouble("day"));
                        JSONArray weatherjArr = wObj.getJSONArray("weather");

                        for (int j = 0; j < weatherjArr.length(); j++) {
                            JSONObject dObj = weatherjArr.getJSONObject(j);
                            forecast.currentCondition.setDescr2(dObj.getString("description"));
                        }
                    }
                    if (i == 2) {
                        JSONObject tempObj = wObj.getJSONObject("temp");
                        forecast.temperature.setTemp3((float) tempObj.getDouble("day"));
                        JSONArray weatherjArr = wObj.getJSONArray("weather");

                        for (int j = 0; j < weatherjArr.length(); j++) {
                            JSONObject dObj = weatherjArr.getJSONObject(j);
                            forecast.currentCondition.setDescr3(dObj.getString("description"));
                        }
                    }
                    if (i == 3) {
                        JSONObject tempObj = wObj.getJSONObject("temp");
                        forecast.temperature.setTemp4((float) tempObj.getDouble("day"));
                        JSONArray weatherjArr = wObj.getJSONArray("weather");

                        for (int j = 0; j < weatherjArr.length(); j++) {
                            JSONObject dObj = weatherjArr.getJSONObject(j);
                            forecast.currentCondition.setDescr4(dObj.getString("description"));
                        }
                    }
                    if (i == 4) {
                        JSONObject tempObj = wObj.getJSONObject("temp");
                        forecast.temperature.setTemp5((float) tempObj.getDouble("day"));
                        JSONArray weatherjArr = wObj.getJSONArray("weather");

                        for (int j = 0; j < weatherjArr.length(); j++) {
                            JSONObject dObj = weatherjArr.getJSONObject(j);
                            forecast.currentCondition.setDescr5(dObj.getString("description"));
                        }
                    }
                }

                return forecast;

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

            return forecast;

        }

        @Override
        protected void onPostExecute(ForecastModel forecastWeather) {
            super.onPostExecute(forecastWeather);

            GregorianCalendar gc = new GregorianCalendar();
            String formattedDate = sdf.format(gc.getTime());
            date1.setText(formattedDate);

            gc.add(Calendar.DATE, 1);
            formattedDate = sdf.format(gc.getTime());
            date2.setText(formattedDate);

            gc.add(Calendar.DATE, 1);
            formattedDate = sdf.format(gc.getTime());
            date3.setText(formattedDate);

            gc.add(Calendar.DATE, 1);
            formattedDate = sdf.format(gc.getTime());
            date4.setText(formattedDate);

            gc.add(Calendar.DATE, 1);
            formattedDate = sdf.format(gc.getTime());
            date5.setText(formattedDate);

            weatherDescription1.setText(forecastWeather.currentCondition.getDescr1());
            temperature1.setText("" + Math.round((forecastWeather.temperature.getTemp1() * 9 / 5 - 459.67)) + " °F");

            weatherDescription2.setText(forecastWeather.currentCondition.getDescr2());
            temperature2.setText("" + Math.round((forecastWeather.temperature.getTemp2() * 9 / 5 - 459.67)) + " °F");

            weatherDescription3.setText(forecastWeather.currentCondition.getDescr3());
            temperature3.setText("" + Math.round((forecastWeather.temperature.getTemp3() * 9 / 5 - 459.67)) + " °F");

            weatherDescription4.setText(forecastWeather.currentCondition.getDescr4());
            temperature4.setText("" + Math.round((forecastWeather.temperature.getTemp4() * 9 / 5 - 459.67)) + " °F");

            weatherDescription5.setText(forecastWeather.currentCondition.getDescr5());
            temperature5.setText("" + Math.round((forecastWeather.temperature.getTemp5() * 9 / 5 - 459.67)) + " °F");
        }



    }


















    //From Android website
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //To maintain state
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
