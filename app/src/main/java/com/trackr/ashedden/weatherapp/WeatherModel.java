package com.trackr.ashedden.weatherapp;

/**
 * Created by Allison on 9/10/2016.
 */

//Used direct lines of code from https://github.com/survivingwithandroid/Swa-app/tree/master/WeatherApp

/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 */
public class WeatherModel {

    public LocationModel location;
    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();

    public  class CurrentCondition {

        private String descr;
        private float humidity;

        public String getDescr() {
            return descr;
        }
        public void setDescr(String descr) {
            this.descr = descr;
        }
        public float getHumidity() {
            return humidity;
        }
        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }


    }

    public  class Temperature {
        private float temp;

        public float getTemp() {
            return temp;
        }
        public void setTemp(float temp) {
            this.temp = temp;
        }

    }

    public  class Wind {
        private float speed;
        public float getSpeed() {
            return speed;
        }
        public void setSpeed(float speed) {
            this.speed = speed;
        }


    }

}
