package com.blikadek.popularmusic;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by M13x5aY on 26/07/2017.
 */

public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //iklan admob
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6251484490939682~8177279052");
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //tombol back pada action bar
        ActionBar kembali= getSupportActionBar();
        kembali.setDisplayShowHomeEnabled(true);
        kembali.setDisplayHomeAsUpEnabled(true);


       tampilkanIntent();
    }

    public void tampilkanIntent() {

        TextView tvArtistDetail = (TextView)findViewById(R.id.tvArtistDetail);
        TextView tvJudulDetail = (TextView)findViewById(R.id.tvJudulDetail);
        ImageView imgArtistDetail = (ImageView)findViewById(R.id.imgArtistdetail);
        TextView tvListenerDetail = (TextView)findViewById(R.id.tvListenerDetail);

        tvArtistDetail.setText(getIntent().getStringExtra("judul"));
        tvJudulDetail.setText(getIntent().getStringExtra("artist"));
        tvListenerDetail.setText(getIntent().getStringExtra("listener")+" Listener");
        Glide.with(this)
                .load(getIntent().getStringExtra("image"))
                .into(imgArtistDetail);
    }

}
