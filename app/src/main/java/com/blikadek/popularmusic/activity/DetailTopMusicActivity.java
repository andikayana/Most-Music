package com.blikadek.popularmusic.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.model.top_track.TrackItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 26/07/2017.
 */

public class DetailTopMusicActivity extends AppCompatActivity{

    @BindView(R.id.webViewDetail)
    WebView mWebView;
    private static final String KEY_TOP_TRACK="track";
    private TrackItem mTrackItem;

    public static void strat(Context context, String newJson){
        Intent intent = new Intent(context, DetailTopMusicActivity.class);
        intent.putExtra(KEY_TOP_TRACK, newJson);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        IklanAdmob();

        //tombol back pada action bar
        ActionBar kembali= getSupportActionBar();
        kembali.setDisplayHomeAsUpEnabled(true);

       tampilkanIntent();
    }

    public void IklanAdmob(){
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6251484490939682~8177279052");
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void tampilkanIntent() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());

        if (getIntent().hasExtra(KEY_TOP_TRACK)){
            String newJson = getIntent().getStringExtra(KEY_TOP_TRACK);
            mTrackItem= new TrackItem().fromJson(newJson);
            mWebView.loadUrl(mTrackItem.getUrl());
            //Toast.makeText(this, "Show news " + mAtriclesItem.getTitle(), Toast.LENGTH_SHORT).show();

            getSupportActionBar().setTitle(mTrackItem.getName());

        }else{
            finish();
        }
    }


}
