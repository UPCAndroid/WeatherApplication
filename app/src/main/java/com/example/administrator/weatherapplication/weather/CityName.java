package com.example.administrator.weatherapplication.weather;

import android.location.Location;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CityName {
    public List<CityResultData> results;
    public static class CityResultData{
        public LocationData location;
    }
    public static class LocationData{
        public String name;
    }
}
