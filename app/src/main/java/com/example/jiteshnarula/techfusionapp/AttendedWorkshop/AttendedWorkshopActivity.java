package com.example.jiteshnarula.techfusionapp.AttendedWorkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.example.jiteshnarula.techfusionapp.prefs.UserSession;
import com.example.jiteshnarula.techfusionapp.splash.StartActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class AttendedWorkshopActivity extends AppCompatActivity {

    Button logoutButton;
    private UserSession session;

    public static final int ACTIVITY_NUMBER = 2;
    private static final String TAG = "AttendedWorkshopActivit";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session  = new UserSession(this);


        Log.d(TAG, "onCreate: Attended workshop class started");
        setUpBottomNavigationView();

        logoutButton = (Button) findViewById(R.id.logoutButton);



        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(AttendedWorkshopActivity.this,StartActivity.class);
                startActivity(logoutIntent);
                 session.setLoggedin(false);
                 finish();


            }
        });
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
