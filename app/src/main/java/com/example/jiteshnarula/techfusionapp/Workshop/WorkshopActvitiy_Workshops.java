package com.example.jiteshnarula.techfusionapp.Workshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.jiteshnarula.techfusionapp.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class WorkshopActvitiy_Workshops extends AppCompatActivity {

    RecyclerView recyclerView;
    WorkshopAdapter workshopAdapter;
    List<Workshop> workshopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_actvitiy__workshops);

        workshopList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(WorkshopActvitiy_Workshops.this));


        String cat = getIntent().getStringExtra("cat");
        String url = "http://192.168.56.1/TechFusion/get_workshops.php?category="+cat;




        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                for(int x=0; x < response.length(); x++ ){
                    try {

                        workshopList.add(new Workshop(response.getJSONObject(x).getInt("wid"),
                                response.getJSONObject(x).getString("name"),
                                response.getJSONObject(x).getDouble("price"),
                                response.getJSONObject(x).getString("photo")
                        ));



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                WorkshopAdapter adapter = new WorkshopAdapter(WorkshopActvitiy_Workshops.this,workshopList);


                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(WorkshopActvitiy_Workshops.this,error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        requestQueue.add(jsonArrayRequest);

    }
}
