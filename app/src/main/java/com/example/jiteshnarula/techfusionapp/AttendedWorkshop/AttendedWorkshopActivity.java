package com.example.jiteshnarula.techfusionapp.AttendedWorkshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class AttendedWorkshopActivity extends AppCompatActivity {
    public static final int ACTIVITY_NUMBER = 2;
    private static final String TAG = "AttendedWorkshopActivit";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Attended workshop class started");
        setUpBottomNavigationView();
    }
    public void setUpBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewHelper.bottomNavigation(AttendedWorkshopActivity.this,bottomNavigationViewEx);

        Menu menu  = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);
    }
}
