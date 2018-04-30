package com.example.jiteshnarula.techfusionapp.Workshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.example.jiteshnarula.techfusionapp.splash.StartActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class WorkshopActivity extends AppCompatActivity {
    public static final int ACTIVITY_NUMBER = 1;
    private static final String TAG = "WorkshopActivity";
    ImageButton mShare;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Workshop Activity Started");
        mShare=(ImageButton)findViewById(R.id.shareImageButton);


        Intent intent = getIntent();
        String result = intent.getStringExtra("workshopTextView");


        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_TEXT,"link");
                startActivity(Intent.createChooser(i,"share via"));
            }
        });


        setUpBottomNavigationView();
    }
    public void setUpBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewHelper.bottomNavigation(WorkshopActivity.this,bottomNavigationViewEx);

        Menu menu  = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);
    }
}
