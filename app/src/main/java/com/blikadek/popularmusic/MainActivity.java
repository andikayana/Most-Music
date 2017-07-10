package com.blikadek.popularmusic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blikadek.popularmusic.adapter.TopTrackAdapter;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private TopTrackAdapter adapter;
//    private List<TrackItem> list;

    private Gson gson = new Gson();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.reciclerView);

        LoadDataTopTracks();
    }

    public void LoadDataTopTracks() {
        String URL = "https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=1e16870e75ef9fc54fa98f2a1c551ec3&format=json";

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            TrackItem[] trackItems = gson.fromJson(response, TrackItem[].class);
                            adapter = new TopTrackAdapter(trackItems, MainActivity.this);
                            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv.setAdapter(adapter);

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }

        );

        queue.add(stringRequest);
    }

}
