package com.example.samirmarin.sunshine.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<String> fakeListWeekWeather = new ArrayList<String>();

        fakeListWeekWeather.add("Today - sunny - 88/63");
        fakeListWeekWeather.add("Tomorrow - cloudy - 75/60");
        fakeListWeekWeather.add("Wednesday - foggy - 70/65");
        fakeListWeekWeather.add("Thursday - showers - 73/64");
        fakeListWeekWeather.add("Friday - sunny - 100/90");
        fakeListWeekWeather.add("Saturday - cloudy - 90/80");
        fakeListWeekWeather.add("Sunday - thunder - 100/95");

        adapter = new ArrayAdapter<String>(
                //the current context(this items parent activity
                getActivity(),
                // ID of list item layout
                R.layout.list_item_forecast,
                // ID of textVie -- specific to popuate
                R.id.list_item_forecast_textview,
                //forecast data;
                fakeListWeekWeather);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView_forecast = (ListView) rootView.findViewById(R.id.listview_forecast);

        listView_forecast.setAdapter(adapter);

        return rootView;
    }
}
