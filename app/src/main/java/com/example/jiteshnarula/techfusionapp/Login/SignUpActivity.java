package com.example.jiteshnarula.techfusionapp.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jiteshnarula.techfusionapp.Home.HomeActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.prefs.UserInfo;
import com.example.jiteshnarula.techfusionapp.prefs.UserSession;

public class SignUpActivity extends AppCompatActivity {

    Button signUpButton;
    EditText nameEditText   ,emailEditText,phoneEditText,passwordEditText;
    Intent homeActivity,loginActivity;
    private ProgressDialog progressDialog;
    private UserSession session;
    private UserInfo userInfo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);


        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);

        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        progressDialog =  new ProgressDialog(this);
        session = new UserSession(this);
        userInfo = new UserInfo(this);


        if(session.isUserLoggedIn()){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }


            signUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressDialog.setMessage("Signing up...");
                    progressDialog.show();

                    String url = "http://192.168.43.81/fusiondb/registered_user.php?name="+nameEditText.getText().toString()+"&email="
                            +emailEditText.getText().toString() +"&phone="+ phoneEditText.getText().toString()+"&password="+
                            passwordEditText.getText().toString();

                    RequestQueue requestQueue  = Volley.newRequestQueue(SignUpActivity.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                                if(response.equalsIgnoreCase(String.valueOf(0))){
                                    progressDialog.hide();
                                    Toast.makeText(SignUpActivity.this,"This email or phone number already exist please try to login",Toast.LENGTH_LONG).show();
                                    session.setLoggedin(false);
                                    loginActivity = new Intent(SignUpActivity.this,SignInActivity.class);
                                     startActivity(loginActivity);
                                     finish();


                                }else if(response.equalsIgnoreCase(String.valueOf(1))) {
                                    userInfo.setEmail(emailEditText.getText().toString());
                                    session.setLoggedin(true);

                                    homeActivity = new Intent(SignUpActivity.this, HomeActivity.class);
                                    startActivity(homeActivity);
                                    finish();
                                    Toast.makeText(SignUpActivity.this, "User has added successfully", Toast.LENGTH_LONG).show();
                                }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(SignUpActivity.this,error.getMessage()+"",Toast.LENGTH_LONG).show();

                            progressDialog.hide();

                        }
                    });

                    requestQueue.add(stringRequest);


                }
            });




    }
}
