package com.example.jiteshnarula.techfusionapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jiteshnarula.techfusionapp.Home.HomeActivity;
import com.example.jiteshnarula.techfusionapp.Login.SignInActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.SharedPreferenceUtils;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homeIntent =  new Intent(SplashActivity.this,StartActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }


}
