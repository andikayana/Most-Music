package com.blikadek.popularmusic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.blikadek.popularmusic.pojo.Artist.ResponseAPIArtist;
import com.blikadek.popularmusic.pojo.ResponseAPI;
import com.google.gson.Gson;

import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class TopArtistActivity extends AppCompatActivity{

    private static final String TAG = TopArtistActivity.class.getSimpleName();
    private RecyclerView rv;
    private TopArtistAdapter adapter;
    SwipeRefreshLayout swipe;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        rv = (RecyclerView) findViewById(R.id.reciclerviewArtist);
        //swipe = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        ButterKnife.bind(this);

        getDataFromApiArtist();


    }

    public void getDataFromApiArtist() {
        final ProgressDialog loading = ProgressDialog.show(this, "Mengambil data","Please Wait..", false, false);

        final String URLA = "http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=1e16870e75ef9fc54fa98f2a1c551ec3&format=json";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, URLA,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);

                        try {
                            loading.dismiss();
                            ResponseAPIArtist responseAPI = gson.fromJson(response, ResponseAPIArtist.class);

                            adapter = new TopArtistAdapter(responseAPI.getArtists().getArtists(), TopArtistActivity.this);
                            rv.setLayoutManager(new LinearLayoutManager(TopArtistActivity.this));
                            rv.setAdapter(adapter);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
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
           /* case R.id.menuMusicTopChart:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menuArtistTopChart:
                startActivity(new Intent(this, TopArtistActivity.class));
                return true;
            case R.id.menuTagTopChart:
                //Toast.makeText(MainActivity.this, "Top Tag", Toast.LENGTH_SHORT).show();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
