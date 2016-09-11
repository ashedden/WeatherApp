package com.trackr.ashedden.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Allison on 9/10/2016.
 */
public class TodaysWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todaysweather);

        Button fiveButton;

        android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("");
        mActionBar  .setDisplayHomeAsUpEnabled(true);

        //Button is clicked, open TodaysWeatherActivity
        fiveButton = (Button) findViewById(R.id.today_button);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FiveDayActivity.class);
                startActivity(i);
            }
        });
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
