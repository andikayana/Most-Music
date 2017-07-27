package com.blikadek.popularmusic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.blikadek.popularmusic.DetailActivity;
import com.blikadek.popularmusic.MainActivity;
import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.blikadek.popularmusic.pojo.Tracks;
import com.blikadek.popularmusic.viewHolder.TrackViewHolder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TopTrackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = TopTrackAdapter.class.getSimpleName();

    private List<TrackItem> trackses;
    private MainActivity mainActivity;



//   private TrackItemClickListener mTrackItemClickCallback;

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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        final TrackItem data = trackses.get(position);
        TrackViewHolder vh = (TrackViewHolder) holder;
        vh.bind(data, position);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mainActivity,  data.getName(), Toast.LENGTH_SHORT).show();
                //holder.getAdapterPosition();
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("judul", data.getName());
                intent.putExtra("artist", data.getArtistItemTopTrack().getNameArtist());
                intent.putExtra("image", data.getImage().get(2).getText());
                intent.putExtra("listener", data.getListeners());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return trackses.size();
    }

    /*public void setTrackItemClickListener(TrackItemClickListener clickListener){
        if (clickListener != null)
            mTrackItemClickCallback = clickListener;
    }

    public interface TrackItemClickListener{
        void onTrackItemClick(TrackItem data, int position);
    }*/


}
