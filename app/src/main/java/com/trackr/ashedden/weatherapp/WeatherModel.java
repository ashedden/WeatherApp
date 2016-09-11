package com.trackr.ashedden.weatherapp;
//
//
///**
// * Created by Allison on 9/10/2016.
// */
//
///**
// * This is a tutorial source code
// * provided "as is" and without warranties.
// *
// * For any question please visit the web site
// * http://www.survivingwithandroid.com
// *
// * or write an email to
// * survivingwithandroid@gmail.com
// *
// */
///*
// * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//public class WeatherModel {
//
//    public LocationModel location;
//    public CurrentCondition currentCondition = new CurrentCondition();
//    public Temperature temperature = new Temperature();
//    public Wind wind = new Wind();
//
//    public  class CurrentCondition {
//        private String weatherDescription;
//        private float humidity;
//
//        public String getWeatherDescription() {
//            return weatherDescription;
//        }
//
//        public void setWeatherDescription(String weatherDescription) {
//            this.weatherDescription = weatherDescription;
//        }
//
//        public float getHumidity() {
//            return humidity;
//        }
//
//        public void setHumidity(float humidity) {
//            this.humidity = humidity;
//        }
//
//
//    }
//
//    public  class Temperature {
//        private float temperature;
//
//        public float getTemperature() {
//            return temperature;
//        }
//
//        public void setTemperature(float temperature) {
//            this.temperature = temperature;
//        }
//    }
//
//    public  class Wind {
//        private float windSpeed;
//
//        public float getWindSpeed() {
//            return windSpeed;
//        }
//
//        public void setWindSpeed(float windSpeed) {
//            this.windSpeed = windSpeed;
//        }
//
//
//    }
//}

/**
 * This is a tutorial source code
 * provided "as is" and without warranties.
 *
 * For any question please visit the web site
 * http://www.survivingwithandroid.com
 *
 * or write an email to
 * survivingwithandroid@gmail.com
 *
 */

/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
