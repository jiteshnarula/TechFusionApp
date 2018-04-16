package com.example.jiteshnarula.techfusionapp.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class UserInfo {
    public static final String TAG = UserInfo.class.getSimpleName();

    public static final String PREF_NAME  = "userinfo";
    public static final String KEY_USERID = "uid";
    public static final String KEY_EMAIL = "email";

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public UserInfo (Context context){
        this.context = context;
        prefs = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = prefs.edit();
    }


public void serUserId(int id){
        editor.putInt(KEY_USERID,id);
        editor.apply();

}


    public void setEmail(String email){
        editor.putString(KEY_EMAIL,email);
        editor.apply();
    }

    public void clearUserInfo(){
        editor.clear();
        editor.commit();

    }

    public String getKeyEmail(){
        return prefs.getString(KEY_EMAIL,"");
    }
}