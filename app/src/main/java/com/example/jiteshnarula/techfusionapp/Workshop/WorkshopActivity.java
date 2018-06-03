package com.example.jiteshnarula.techfusionapp.Workshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.jiteshnarula.techfusionapp.R;
import com.example.jiteshnarula.techfusionapp.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

//<<<<<<< HEAD
//=======
//>>>>>>> origin/master

public class WorkshopActivity extends AppCompatActivity {
    public static final int ACTIVITY_NUMBER = 1;
    private static final String TAG = "WorkshopActivity";
//<<<<<<< HEAD
//=======
    ListView listView;


    String url;

//>>>>>>> origin/master
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_layout);
        Log.d(TAG, "onCreate: Workshop Activity Started");



        listView = (ListView) findViewById(R.id.listView);
        url = "http://localhost/fusiondb/get_workshopcategory.php";

        final ArrayList<String> arrayList  =  new ArrayList<>();


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int x = 0; x <= response.length() - 1; x++){


                    try {
                        arrayList.add(response.getJSONObject(x).getString("category"));
                        ArrayAdapter arrayAdapter = new ArrayAdapter(WorkshopActivity.this,android.R.layout.simple_list_item_1,arrayList);
                        listView.setAdapter(arrayAdapter);

                    } catch (JSONException e) {
                        toastMessage(e.getMessage());
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                toastMessage(error.getMessage());
            }
        });
requestQueue.add(jsonArrayRequest);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cat  = arrayList.get(position);
                Intent intent = new Intent(WorkshopActivity.this,WorkshopActvitiy_Workshops.class);
                intent.putExtra("cat",cat);
                startActivity(intent);
                finish();
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


    public  void toastMessage(String msg){
        Toast.makeText(WorkshopActivity.this,msg,Toast.LENGTH_LONG).show();
    }
}
