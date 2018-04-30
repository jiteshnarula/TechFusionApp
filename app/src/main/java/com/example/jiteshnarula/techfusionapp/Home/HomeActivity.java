package com.example.jiteshnarula.techfusionapp.Home;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jiteshnarula.techfusionapp.Login.SignInActivity;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.example.jiteshnarula.techfusionapp.Workshop.WorkshopActivity;
import com.example.jiteshnarula.techfusionapp.prefs.UserInfo;
import com.example.jiteshnarula.techfusionapp.prefs.UserSession;
import com.example.jiteshnarula.techfusionapp.splash.StartActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    public static final int ACTIVITY_NUMBER = 0;
    private static final String TAG = "HomeActivity";
    private UserInfo userInfo;
    private UserSession userSession;
    public static FragmentManager fragmentManager;
    //Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        Log.d(TAG, "onCreate: Home Activity Started");
        setUpBottomNavigationView();

        userInfo = new UserInfo(this);
        userSession =  new UserSession(this);
        //logoutButton  =  (Button) findViewById(R.id.logoutButton);

//        if(!userSession.isUserLoggedIn()){
//            startActivity(new Intent(HomeActivity.this, StartActivity.class));
//            finish();
//        }


//        logoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                userSession.setLoggedin(false);
//                userInfo.clearUserInfo();
//                startActivity(new Intent(HomeActivity.this,StartActivity.class));
//                finish();
//            }
//        });

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_container2)!=null && findViewById(R.id.fragment_container1)!=null){

            if(savedInstanceState!=null){
                return;

            }
            android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container2,new AboutUsFragment(),null);
            fragmentTransaction.add(R.id.fragment_container1,new AdvertismentFragment(),null);
            fragmentTransaction.commit();



        }


    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.share,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id)
        {
            case R.id.sharebutton:
                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_TEXT,"link");
                startActivity(Intent.createChooser(i,"share via"));
                break;

        }
        return true;
    }




/*
 *Bottom Navigation View Setup using external library
 */

    public void setUpBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewHelper.bottomNavigation(HomeActivity.this,bottomNavigationViewEx);

        Menu menu  = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);
    }
}
