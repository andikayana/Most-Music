package com.blikadek.popularmusic.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.blikadek.popularmusic.viewHolder.TrackViewHolder;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TopTrackAdapter extends RecyclerView.Adapter<TrackViewHolder> {

    private TrackItem[] trackItem;
    private Activity activity;



    public TopTrackAdapter(TrackItem[] trackItems, Activity activity) {
        this.trackItem=trackItems;
        this.activity=activity;

    }


    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_item, parent, false);
        return new TrackViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        holder.bind(trackItem[position], activity);
    }

    @Override
    public int getItemCount() {
        return trackItem.length;
    }
}
