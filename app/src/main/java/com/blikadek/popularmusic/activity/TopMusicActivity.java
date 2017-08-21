package com.blikadek.popularmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.blikadek.popularmusic.BuildConfig;
import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.adapter.TopTrackAdapter;
import com.blikadek.popularmusic.adapter.TopTrackClickListener;
import com.blikadek.popularmusic.model.top_track.ApiResponse;
import com.blikadek.popularmusic.model.top_track.TrackItem;
import com.blikadek.popularmusic.rest.ApiClient;
import com.blikadek.popularmusic.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TopMusicActivity extends AppCompatActivity implements TopTrackClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = TopMusicActivity.class.getSimpleName();

    LinearLayoutManager mLinearLayoutManager;
    @BindView(R.id.reciclerview) RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefreshLayout;
    TopTrackAdapter mAdapterApi;
    private List<TrackItem> mTrackItem = new ArrayList<>();

    private final String TOP_TRACK_SOURCE="chart.gettoptracks";
    private final String TOP_TRACK_FORMAT="json";

    private String selectedSort;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //menambahkan gambar di actionbar
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Top Music");
        getSupportActionBar().setSubtitle("Andika Yana");

        //SETUp Adapter
        mAdapterApi = new TopTrackAdapter(mTrackItem);
        mAdapterApi.setTrackItemClickListener(this);

        //SETUP RECYCLERVIEW
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapterApi);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                getDataFromApi();
            }
        });

    }

    @Override
    public void onRefresh() {
        getDataFromApi();
    }

    public void getDataFromApi(){
        ApiService apiService = ApiClient.getRetrofitClient().create(ApiService.class);
        Call<ApiResponse> apiResponseCall = apiService.getTopTracks(
                TOP_TRACK_SOURCE,
                BuildConfig.API_KEY,
                TOP_TRACK_FORMAT
        );
        Log.d(TAG, "getData: API_KEY " + BuildConfig.API_KEY);

        apiResponseCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, retrofit2.Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();
                if (apiResponse != null) {

                    Log.d(TAG, "onResponse: " + response);

                    mTrackItem = apiResponse.getTracks().getTrack();
                    mAdapterApi.setData(mTrackItem);
                    swipeRefreshLayout.setRefreshing(false);

                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(TopMusicActivity.this, "Call failed " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    public void onItemTopTrackClicked(TrackItem trackItem) {
        DetailTopMusicActivity.strat(this, trackItem.toJson());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuMusicTopChart:
                return true;
            case R.id.menuArtistTopChart:
                Intent intent = new Intent(TopMusicActivity.this, TopArtistActivity.class);
                startActivity(intent);
                TopMusicActivity.this.finish();
                return true;
            case R.id.menuTagTopChart:
                Toast.makeText(TopMusicActivity.this, "Top Tag", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
