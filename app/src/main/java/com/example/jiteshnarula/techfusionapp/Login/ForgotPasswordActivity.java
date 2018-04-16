package com.example.jiteshnarula.techfusionapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jiteshnarula.techfusionapp.R;

public class ForgotPasswordActivity extends AppCompatActivity{

    EditText ForgotEmail;
    Button ForgotButton;
    TextView BackToLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ForgotEmail=(EditText)findViewById(R.id.ForgotEmail);
        ForgotButton=(Button)findViewById(R.id.ForgotButton);
        BackToLogin=(TextView)findViewById(R.id.BackToLogin);

        BackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent JumpBack= new Intent(ForgotPasswordActivity.this,SignInActivity.class);
                startActivity(JumpBack);
            }
        });

    }
}
