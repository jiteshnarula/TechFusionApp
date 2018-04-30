package com.example.jiteshnarula.techfusionapp.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.jiteshnarula.techfusionapp.AttendedWorkshop.AttendedWorkshopActivity;
import com.example.jiteshnarula.techfusionapp.Home.HomeActivity;
import com.example.jiteshnarula.techfusionapp.More.MoreActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Videos.VideosActivity;
import com.example.jiteshnarula.techfusionapp.Workshop.WorkshopActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper  {
    private static final String TAG = "BottomNavigationViewHel";

    public void setUpBottomNavigationView(BottomNavigationViewEx bottomNavigationView){
        bottomNavigationView.enableAnimation(true);
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.setTextVisibility(true);
    }

    public void bottomNavigation(final Context context,BottomNavigationViewEx view){

    view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){


                case R.id.ic_home:
                    Intent intent  =  new Intent(context, HomeActivity.class);//activity number 0
                    context.startActivity(intent);
                    break;

                case R.id.ic_workshop:
                    Intent intent2 = new Intent(context, WorkshopActivity.class); //activitynumebr 1
                    context.startActivity(intent2);
                    break;

                case R.id.ic_aw:
                    Intent intent3 = new Intent(context, AttendedWorkshopActivity.class); //activity number =2
                    context.startActivity(intent3);
                    break;

                case R.id.ic_video:
                    Intent intent4 = new Intent(context,VideosActivity.class); //activity number 3
                    context.startActivity(intent4);
                    break;
                case R.id.ic_more:
                    Intent intent5 = new Intent(context, MoreActivity.class); //activity number = 4
                    context.startActivity(intent5);
                    break;


            }


            return false;
        }
    });

    }


}
