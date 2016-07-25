package com.example.administrator.weatherapplication.weather;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Weather implements Serializable{




        public List<ResultData> results;

        public static class ResultData {
            public Aqi aqi;
            public Basic basic;
            public List<DailyForecast> daily_forecast;
            public List<HourlyForecast> hourly_forecast;
            public Now now;
            public String status;
            public Suggestion suggestion;
        }
        public static class Aqi{
            public City city;
        }
        public static class City{
            public String aqi;
            public String co;
            public String no2;
            public String o3;
            public String pm10;
            public String pm25;
            public String qlty;
            public String so2;
        }
        public static class Basic{
            public String city;
            public String cnty;
            public String id;
            public Update update;

        }
        public static class Update{
            public String loc;
        }
        public static class DailyForecast{
            public Astro astro;
            public Cond cond;
            public String date;
            public String hum;
            public String pcpn;
            public String pop;
            public String pres;
            public Tmp tmp;
            public String vis;
            public Wind wind;

        }
        public static class Astro{
            public String sr;
            public String ss;
        }
        public static class Cond{
            public String code_d;
            public String code_n;
            public String txt_d;
            public String txt_n;
        }
        public static class Tmp{
            public String max;
            public String min;
        }
        public static class Wind{
            public String deg;
            public String dir;
            public String sc;
            public String spd;
        }
        public static class HourlyForecast{
            public String date;
            public String hum;
            public String pop;
            public String tmp;
            public Wind wind;
        }
        public static class Now{
            public CondNow code;
            public String fl;
            public String hum;
            public String pcpn;
            public String pres;
            public String tmp;
            public String vis;
            public Wind wind;

        }
        public static class CondNow{
            public String code;
            public String txt;
        }
        public static class Suggestion{
            public Detail comf;
            public Detail cw;
            public Detail drsg;
            public Detail flu;
            public Detail sport;
            public Detail trav;
            public Detail uv;
        }
        public static class Detail{
            public String brf;
            public String txt;
        }











}
