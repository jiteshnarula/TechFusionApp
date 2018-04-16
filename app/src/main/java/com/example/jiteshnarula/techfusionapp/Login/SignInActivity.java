package com.example.jiteshnarula.techfusionapp.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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
import com.example.jiteshnarula.techfusionapp.AppCommonContext;
import com.example.jiteshnarula.techfusionapp.Home.HomeActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.prefs.UserInfo;
import com.example.jiteshnarula.techfusionapp.prefs.UserSession;

public class SignInActivity extends AppCompatActivity {

        Button signInButton;
        Button ForgotPass;
        EditText emailEditText,passwordEditText;
        Intent homeActivity;
        private ProgressDialog progressDialog;
        private UserSession session;
        private UserInfo userInfo;



        @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signin);

        signInButton = (Button) findViewById(R.id.signInButton);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText =  (EditText) findViewById(R.id.passwordEditText);
        progressDialog  = new ProgressDialog(this);
        session  = new UserSession(this);
        ForgotPass=(Button)findViewById(R.id.ForgotPass);
        userInfo = new UserInfo(this);



        if(session.isUserLoggedIn()){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }

        ForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent JumpToForgot = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(JumpToForgot);
            }
        });


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tag_string_req = "req_login";
                progressDialog.setMessage("Logging in...");
                progressDialog.show();




                    String url = "http://192.168.43.81/fusiondb/login.php?email="+emailEditText.getText().toString() +
                            "&password="+passwordEditText.getText().toString();

                RequestQueue requestQueue  = Volley.newRequestQueue(SignInActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equals("0")){

                            Toast.makeText(SignInActivity.this,"Login Failed try to reset password",Toast.LENGTH_LONG).show();


                        }else
                            userInfo.setEmail(emailEditText.getText().toString());
                            session.setLoggedin(true);

                            homeActivity =  new Intent(SignInActivity.this, HomeActivity.class);
                             startActivity(homeActivity);
                             finish();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(SignInActivity.this,error.getMessage()+"",Toast.LENGTH_LONG).show();
                        progressDialog.hide();


                    }
                });

                requestQueue.add(stringRequest);

            }
        });



    }
}
