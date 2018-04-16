package com.example.jiteshnarula.techfusionapp.Videos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class VideosActivity extends AppCompatActivity {
    public static final int ACTIVITY_NUMBER = 3;
    private static final String TAG = "VideosActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Videos Activity class started");
        setUpBottomNavigationView();
    }
    public void setUpBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewHelper.bottomNavigation(VideosActivity.this,bottomNavigationViewEx);
        Menu menu  = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);

    }
}