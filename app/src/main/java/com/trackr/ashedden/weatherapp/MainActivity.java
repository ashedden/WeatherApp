package com.trackr.ashedden.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button searchButton;
    EditText editText;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext);

        //Button is clicked, open TodaysWeatherActivity
        searchButton = (Button) findViewById(R.id.main_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get input from EditText
                city = editText.getText().toString();

                Log.e("HELP", city);
                if (city.matches("")) {
                    city = "santabarbara,us";
                    Intent i = new Intent(MainActivity.this, TodaysWeatherActivity.class);
                    i.putExtra("city", city);
                    startActivity(i);
                }else {
                    Intent i = new Intent(MainActivity.this, TodaysWeatherActivity.class);
                    i.putExtra("city", city);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
