package com.example.jiteshnarula.techfusionapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jiteshnarula.techfusionapp.AppCommonContext;

public class SharedPreferenceUtils {

    private static String PREFRENCE_NAME = "TechFusion";
    private static SharedPreferenceUtils sharedPreferenceUtils;
    private SharedPreferences sharedPreferences;


    public SharedPreferenceUtils(Context context){
        PREFRENCE_NAME = PREFRENCE_NAME + context.getPackageName();
        this.sharedPreferences = context.getSharedPreferences(PREFRENCE_NAME, Context.MODE_PRIVATE);

    }

    public static SharedPreferenceUtils getInstance(){
        if(sharedPreferenceUtils == null) {
            sharedPreferenceUtils = new SharedPreferenceUtils(AppCommonContext.getContext());
        }
        return  sharedPreferenceUtils;
    }

    //saving sting int and float value


    public void saveString(String key,String value){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String getString(String key){

        return sharedPreferences.getString(key,"");
    }

}
