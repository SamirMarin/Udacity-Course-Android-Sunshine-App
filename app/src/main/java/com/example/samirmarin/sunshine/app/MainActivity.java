package com.example.samirmarin.sunshine.app;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    private void openPreferLocation(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String location = PreferenceManager.getDefaultSharedPreferences(this).
                getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default));
        intent.setData(Uri.parse("geo:0,0?q="+location));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else {
            Log.d(LOG_TAG, "could not call " + location + " no receiving apps installed");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            return true;
        }
        // calling location on overflow menu
        if (id == R.id.map_location){
            openPreferLocation();
            return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
