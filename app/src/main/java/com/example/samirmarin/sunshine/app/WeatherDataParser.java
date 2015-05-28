package com.example.samirmarin.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by samirmarin on 15-05-27.
 */
public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        double maxTemp = 0;
        // TODO: add parsing code here
        JSONObject object = new JSONObject(weatherJsonStr);
        //JSONObject object = theObject.getJSONObject("city");
        JSONArray arr = object.getJSONArray("list");
        for(int i = 0 ; i < arr.length(); i++){
            JSONObject obj = arr.getJSONObject(i);
           // if(obj.getInt("dt") == dayIndex){
            if(i == dayIndex){
                JSONObject objTemp = obj.getJSONObject("temp");
                maxTemp = objTemp.getDouble("max");
                return maxTemp;
            }
        }
        return maxTemp;
    }

}




