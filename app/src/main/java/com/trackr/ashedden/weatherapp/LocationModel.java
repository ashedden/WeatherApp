package com.trackr.ashedden.weatherapp;

import java.io.Serializable;

/**
 * Created by Allison on 9/10/2016.
 */

//Used direct lines of code from https://github.com/survivingwithandroid/Swa-app/tree/master/WeatherApp

/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 */
public class LocationModel implements Serializable {

    private String country;
    private String city;

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }




}