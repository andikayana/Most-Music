package com.blikadek.popularmusic.viewHolder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TrackViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tvJudulTrack)
    TextView name;
    @BindView(R.id.tvListener)
    TextView listeners;
    @BindView(R.id.imgTrack)
    ImageView image;
    @BindView(R.id.tvArtist)
    TextView artist;

    public TrackViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(TrackItem data, int position) {
        artist.setText(data.getArtistItem().getNameArtist());
        name.setText(data.getName());
        listeners.setText(data.getListeners());
        Glide.with(itemView.getContext())
                .load(data.getImage().get(1).getText())
                .into(image);
    }

}
