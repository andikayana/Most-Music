package com.blikadek.popularmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.blikadek.popularmusic.BuildConfig;
import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.adapter.TopArtistAdapter;
import com.blikadek.popularmusic.model.top_artist.ApiResponseArtist;
import com.blikadek.popularmusic.model.top_artist.ArtistItem;
import com.blikadek.popularmusic.rest.ApiClient;
import com.blikadek.popularmusic.rest.ApiService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class TopArtistActivity extends AppCompatActivity{

    private static final String TAG = TopArtistActivity.class.getSimpleName();

    @BindView(R.id.reciclerviewArtist) RecyclerView mRecyclerView;

    private List<ArtistItem> mArtistItemList = new ArrayList<>();
    private final String TOP_ARTIST_SOURCE="chart.gettopartists";
    private final String TOP_ARTIST_FORMAT="json";
    LinearLayoutManager mLinearLayoutManager;
    private TopArtistAdapter mAdapterApiArtist;
    //SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ButterKnife.bind(this);


        //menambahkan gambar di actionbar
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("Top Artist");
        getSupportActionBar().setSubtitle("Andika Yana");

        //SETUp Adapter
        mAdapterApiArtist = new TopArtistAdapter(mArtistItemList);
        //mAdapterApiArtist.setTrackItemClickListener(this);

        //SETUP RECYCLERVIEW
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapterApiArtist);

        getDataFromApiArtist();

        /*swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                getDataFromApi();
            }
        });*/


    }

    public void getDataFromApiArtist() {

        ApiService apiService = ApiClient.getRetrofitClient().create(ApiService.class);
        Call<ApiResponseArtist> apiResponseArtistCall = apiService.getTopArtist(
                TOP_ARTIST_SOURCE,
                BuildConfig.API_KEY,
                TOP_ARTIST_FORMAT
        );

        Log.d(TAG, "Get DAta : Api Key " + BuildConfig.API_KEY);
        apiResponseArtistCall.enqueue(new Callback<ApiResponseArtist>() {
            @Override
            public void onResponse(Call<ApiResponseArtist> call, retrofit2.Response<ApiResponseArtist> response) {
                ApiResponseArtist apiResponseArtist = response.body();
                if (apiResponseArtist != null) {
                    Log.d(TAG, "onRespone: " + response);
                    mArtistItemList = apiResponseArtist.getArtists().getArtist();
                    mAdapterApiArtist.setData(mArtistItemList);
                }
            }

            @Override
            public void onFailure(Call<ApiResponseArtist> call, Throwable t) {
                Toast.makeText(TopArtistActivity.this, "Call Failed " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure : " , t);
            }
        });

        /*
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(TopMusicActivity.this, "Call failed " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });*/
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
                Intent intent = new Intent(TopArtistActivity.this, TopMusicActivity.class);
                startActivity(intent);
                TopArtistActivity.this.finish();
                return true;
            case R.id.menuArtistTopChart:
                return true;
            case R.id.menuTagTopChart:
                Toast.makeText(this, "Top Tag", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
