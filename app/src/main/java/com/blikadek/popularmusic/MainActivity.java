package com.blikadek.popularmusic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blikadek.popularmusic.adapter.TopArtistAdapter;
import com.blikadek.popularmusic.adapter.TopTrackAdapter;
import com.blikadek.popularmusic.pojo.ResponseAPI;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.blikadek.popularmusic.pojo.Tracks;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
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


    private RecyclerView rv;
    TopTrackAdapter adapter;
    SwipeRefreshLayout swipe;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menambahkan gambar di actionbar
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Top Music");
        getSupportActionBar().setSubtitle("Andika Yana");

        rv = (RecyclerView) findViewById(R.id.reciclerview);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        ButterKnife.bind(this);

        getDataFromApi();

    }

    public void getDataFromApi(){

        //final ProgressDialog loading = ProgressDialog.show(this, "Mengambil data","Please Wait..", false, false);
        final String URL = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=1e16870e75ef9fc54fa98f2a1c551ec3&format=json";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, URL,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);
                        //loading.dismiss();
                        try {

                            ResponseAPI responseAPI = gson.fromJson(response, ResponseAPI.class);

                            adapter = new TopTrackAdapter(responseAPI.getTracks().getTrack(), MainActivity.this);
                            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv.setAdapter(adapter);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuMusicTopChart:
                //startActivity(new Intent(this, MainActivity.class));
                //return true;
            case R.id.menuArtistTopChart:
                Intent intent = new Intent(MainActivity.this, TopArtistActivity.class);
                startActivity(intent);
               return true;
            case R.id.menuTagTopChart:
                Toast.makeText(MainActivity.this, "Top Tag", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



}
