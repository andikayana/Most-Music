package com.blikadek.popularmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blikadek.popularmusic.MainActivity;
import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.TopArtistActivity;
import com.blikadek.popularmusic.pojo.Artist.ArtistItem;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.blikadek.popularmusic.viewHolder.ArtistViewHolder;
import com.blikadek.popularmusic.viewHolder.TrackViewHolder;

import java.util.List;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class TopArtistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = TopArtistAdapter.class.getSimpleName();
    private List<ArtistItem> artistItems;
    private TopArtistActivity topArtistActivity;

    public TopArtistAdapter(List<ArtistItem> artistItems, TopArtistActivity topArtistActivity){
       // this.artistItems.clear();
        this.artistItems=artistItems;
        this.topArtistActivity=topArtistActivity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_item, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ArtistItem data = artistItems.get(position);
        ArtistViewHolder vh = (ArtistViewHolder) holder;
        vh.bind(data, position);
    }

    @Override
    public int getItemCount() {
      return artistItems.size();
    }
}
