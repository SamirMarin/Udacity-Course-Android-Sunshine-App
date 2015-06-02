
package com.example.samirmarin.sunshine.app;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;



/**
 * A placeholder fragment containing a simple view.
 */

public class DetailActivityFragment extends Fragment {

    private static final String LOG_CAT = DetailActivity.class.getSimpleName();
    private static final String HASH_TAG_SHARE = " #SunshineApp";
    private String mWeatherDataForecast;
    //private ShareActionProvider shareActionProvider;

    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detailfragment, menu);

        //locate menu item with shareprovider
        MenuItem menuItem = menu.findItem(R.id.action_share);

        //get the provider

        ShareActionProvider shareActionProvider;
        //other method also works but with a bit different interace for menu
        // shareActionProvider = new ShareActionProvider(this);
        //MenuItemCompat.setActionProvider(menuItem, shareActionProvider);

        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        //attach intent to the shareActionProvider
        if(shareActionProvider != null){
            shareActionProvider.setShareIntent(createShareIntentForcast());
        }
        else{
            Log.d(LOG_CAT, "share action provider is null");
        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        //set the forecast data on detail activity textview using the fragment.. referece by the id
        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(intent.EXTRA_TEXT)){
            mWeatherDataForecast = intent.getStringExtra(intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.detailed_text)).setText(mWeatherDataForecast);
        }


        return rootView;
    }

    private Intent createShareIntentForcast(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mWeatherDataForecast+HASH_TAG_SHARE);
        return shareIntent;
    }
}

