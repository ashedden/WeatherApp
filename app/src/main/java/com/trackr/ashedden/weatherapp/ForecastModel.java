package com.trackr.ashedden.weatherapp;

/**
 * Created by Allison on 9/11/2016.
 */

//Used direct lines of code from https://github.com/survivingwithandroid/Swa-app/tree/master/WeatherApp

/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 */

public class ForecastModel {

    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();

    public  class CurrentCondition {

        private String descr1, descr2, descr3, descr4, descr5;

        public String getDescr1() {
            return descr1;
        }
        public void setDescr1(String descr1) {
            this.descr1 = descr1;
        }
        public String getDescr2() {
            return descr2;
        }
        public void setDescr2(String descr2) {
            this.descr2 = descr2;
        }
        public String getDescr3() {
            return descr3;
        }
        public void setDescr3(String descr3) {
            this.descr3 = descr3;
        }
        public String getDescr4() {
            return descr4;
        }
        public void setDescr4(String descr4) {
            this.descr4 = descr4;
        }
        public String getDescr5() {
            return descr5;
        }
        public void setDescr5(String descr5) {
            this.descr5 = descr5;
        }

    }

    public  class Temperature {
        private float temp1, temp2, temp3, temp4, temp5;

        public float getTemp1() {
            return temp1;
        }
        public void setTemp1(float temp1) {
            this.temp1 = temp1;
        }
        public float getTemp2() {
            return temp2;
        }
        public void setTemp2(float temp2) {
            this.temp2 = temp2;
        }
        public float getTemp3() {
            return temp3;
        }
        public void setTemp3(float temp3) {
            this.temp3 = temp3;
        }
        public float getTemp4() {
            return temp4;
        }
        public void setTemp4(float temp4) {
            this.temp4 = temp4;
        }
        public float getTemp5() {
            return temp5;
        }
        public void setTemp5(float temp5) {
            this.temp5 = temp5;
        }

    }

}

