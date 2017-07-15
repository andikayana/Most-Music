package com.blikadek.popularmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.blikadek.popularmusic.MainActivity;
import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.blikadek.popularmusic.pojo.Tracks;
import com.blikadek.popularmusic.viewHolder.TrackViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TopTrackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = TopTrackAdapter.class.getSimpleName();

    //private TrackItem[] trackses;
    private List<TrackItem> trackses;
    private MainActivity mainActivity;

//    private ForecastItemClickListener mForecastClickCallback;

    /*public TopTrackAdapter(TrackItem[] trackItems, MainActivity mainActivity) {
        this.trackItems = trackItems;
        this.mainActivity=mainActivity;
    }*/

    public TopTrackAdapter(List<TrackItem> trackses, MainActivity mainActivity) {
        this.trackses=trackses;
        this.mainActivity=mainActivity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_item, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

//        TrackItem item = trackses[position];
//        TrackViewHolder vh = (TrackViewHolder) holder;
//        vh.bind(item, position);

        final TrackItem data = trackses.get(position);
        TrackViewHolder vh = (TrackViewHolder) holder;
        vh.bind(data, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mForecastClickCallback.onForecastItemClick(data, position);

            }
        });
    }

    @Override
    public int getItemCount() {
        //return trackses.length;
        return trackses.size();
    }


}
