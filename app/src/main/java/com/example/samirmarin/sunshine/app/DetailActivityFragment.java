package com.example.samirmarin.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        //set the forecast data on detail activity textview using the fragment.. referece by the id
        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(intent.EXTRA_TEXT)){
            String weatherDataForecast = intent.getStringExtra(intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.detailed_text)).setText(weatherDataForecast);
        }


        return rootView;
    }
}
