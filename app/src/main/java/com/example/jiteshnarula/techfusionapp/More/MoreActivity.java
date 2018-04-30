package com.example.jiteshnarula.techfusionapp.More;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class MoreActivity extends AppCompatActivity {
    private static final String TAG = "MoreActivity";
    public static final int ACTIVITY_NUMBER = 4;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adaptar;
    ArrayList<String> data=new ArrayList<>();
    ArrayList<Integer> imageArrayList=new ArrayList<Integer>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_more);
        data.add("About Us");
        data.add("FAQs");
        data.add("Our Goals");
        data.add("Our Partners");
        data.add("Contact Us");
        imageArrayList.add(R.drawable.about_us);
        imageArrayList.add(R.drawable.faqs);
        imageArrayList.add(R.drawable.our_goal);
        imageArrayList.add(R.drawable.our_partners);
        imageArrayList.add(R.drawable.contact_us);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // Log.d("krishna", "onCreate: Before"+mAdapter);
        adaptar=new CustomRecyclerViewAdapter(MoreActivity.this,data,imageArrayList);
        Log.d("krishna", "onCreate: after "+adaptar);
        recyclerView.setAdapter(adaptar);

        Log.d("krishna", "onCreate: More Activity class started");
        setUpBottomNavigationView();
    }
    public void setUpBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewHelper.bottomNavigation(MoreActivity.this,bottomNavigationViewEx);

        Menu menu  = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);
    }
}