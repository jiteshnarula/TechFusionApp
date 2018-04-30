package com.example.jiteshnarula.techfusionapp.splash;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiteshnarula.techfusionapp.Home.HomeActivity;
import com.example.jiteshnarula.techfusionapp.Login.SignInActivity;
import com.example.jiteshnarula.techfusionapp.Login.SignUpActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.example.jiteshnarula.techfusionapp.Workshop.WorkshopActivity;
import com.example.jiteshnarula.techfusionapp.prefs.UserInfo;
import com.example.jiteshnarula.techfusionapp.prefs.UserSession;

public class StartActivity extends AppCompatActivity {
Button signUpButton;
UserInfo userInfo;
UserSession session;
TextView exploreWorkshopTextView,signInTextview;
BottomNavigationViewHelper bottomNavigationViewHelper;
private ViewPager mSlideViewPager;
private LinearLayout mDotLayout;
private SliderAdapter sliderAdapter;
private  TextView[] mdots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mSlideViewPager=findViewById(R.id.slideviewpager);
        mDotLayout=findViewById(R.id.dotslayout);
        sliderAdapter= new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);


        signInTextview = (TextView) findViewById(R.id.signInTextview);
        signUpButton  = (Button) findViewById(R.id.signUpButton);
        exploreWorkshopTextView = (TextView) findViewById(R.id.exploreWorkshopTextView);

        userInfo = new UserInfo(this);
        session = new UserSession(this);



        if(session.isUserLoggedIn()){
            startActivity(new Intent(StartActivity.this, HomeActivity.class));
            finish();
        }

        exploreWorkshopTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workshopIntent =  new Intent(StartActivity.this,WorkshopActivity.class);

                workshopIntent.putExtra("workshopTextView",exploreWorkshopTextView.getId());
                startActivity(workshopIntent);
            }
        });

        signInTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(StartActivity.this, SignInActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

    }
    public void addDotsIndicator(int position){
        mdots=new TextView[3];
        mDotLayout.removeAllViews();
        for (int i=0;i<mdots.length;i++){
            mdots[i]=new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.black));
            mDotLayout.addView(mdots[i]);
        }
        if(mdots.length>0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
