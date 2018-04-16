package com.example.jiteshnarula.techfusionapp.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession {

    public static final String TAG  = UserSession.class.getSimpleName();
    public static final String  PREF_NAME = "login";
    public static final String KEY_IS_LOGGED_IN  ="isloggedin";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;


    public UserSession(Context context){

        this.context =  context;
        prefs = context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);
        editor =  prefs.edit();
    }

    public void setLoggedin(boolean isLoggedIn){

        editor.putBoolean(KEY_IS_LOGGED_IN,isLoggedIn);
        editor.apply();

    }

    public boolean isUserLoggedIn(){

        return prefs.getBoolean(KEY_IS_LOGGED_IN,false);
    }


}
