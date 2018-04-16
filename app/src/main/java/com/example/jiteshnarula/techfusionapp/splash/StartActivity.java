package com.example.jiteshnarula.techfusionapp.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jiteshnarula.techfusionapp.Home.HomeActivity;
import com.example.jiteshnarula.techfusionapp.Login.SignInActivity;
import com.example.jiteshnarula.techfusionapp.Login.SignUpActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.prefs.UserInfo;
import com.example.jiteshnarula.techfusionapp.prefs.UserSession;

public class StartActivity extends AppCompatActivity {
Button signInButton,signUpButton;
UserInfo userInfo;
UserSession session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        signInButton = (Button) findViewById(R.id.signInButton);
        signUpButton  = (Button) findViewById(R.id.signUpButton);

        userInfo = new UserInfo(this);
        session = new UserSession(this);

        if(session.isUserLoggedIn()){
            startActivity(new Intent(StartActivity.this, HomeActivity.class));
            finish();
        }

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(StartActivity.this, SignInActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent = new Intent(StartActivity.this, SignUpActivity.class);
                startActivity(signupIntent);
                finish();
            }
        });


    }
}
