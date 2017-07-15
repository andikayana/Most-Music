package com.blikadek.popularmusic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blikadek.popularmusic.adapter.TopTrackAdapter;
import com.blikadek.popularmusic.pojo.ResponseAPI;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.blikadek.popularmusic.pojo.Tracks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

//    @BindView(R.id.reciclerview) RecyclerView rv;
    private RecyclerView rv;
    TopTrackAdapter adapter;
    private final List<TrackItem> list = new ArrayList<>();
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.reciclerview);
        //rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ButterKnife.bind(this);

        getDataFromApi();
    }

    public void getDataFromApi(){

        final String URL = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=1e16870e75ef9fc54fa98f2a1c551ec3&format=json";

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, URL,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);

                        try {
                            ResponseAPI responseAPI = gson.fromJson(response, ResponseAPI.class);
                            //TrackItem[] trackses = gson.fromJson(response, TrackItem[].class);
                            //Tracks apiResponse = gson.fromJson(response, Tracks.class);

                            adapter = new TopTrackAdapter(responseAPI.getTracks().getTrack(), MainActivity.this);
                            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv.setAdapter(adapter);


/*
                            for (TrackItem tracks : apiResponse.getTrack()) {
                                list.add(tracks);
                            }*/
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }


                            //Response.Listener<String> responseListener = new Response.Listener<String>() {
                                 /*@Override
                            public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);

                        //TrackItem[] trackses = gson.fromJson(response, TrackItem[].class);
                        Tracks apiResponse = gson.fromJson(response, Tracks.class);

                        //adapter = new TopTrackAdapter(apiResponse, MainActivity.this);
                        //rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        //rv.setAdapter(adapter);

                       // ResponseAPI responseAPI = gson.fromJson(response, ResponseAPI.class);

                        for (TrackItem tracks: apiResponse.getTrack()){
                            list.add(tracks);
                        }

                adapter.notifyDataSetChanged();
*/
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );

        queue.add(stringRequest);

    }

}
