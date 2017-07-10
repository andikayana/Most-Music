package com.blikadek.popularmusic.viewHolder;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.pojo.TrackItem;
import com.bumptech.glide.Glide;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TrackViewHolder extends RecyclerView.ViewHolder {

    private TextView name, listeners;
    private ImageView url;

    public TrackViewHolder(View itemView) {
        super(itemView);

        name = (TextView)itemView.findViewById(R.id.tvJudulTrack);
        listeners = (TextView)itemView.findViewById(R.id.tvListener);
        url = (ImageView)itemView.findViewById(R.id.imgTrack);
    }

    public void bind(final TrackItem data, final Activity activity) {
        name.setText(data.getName());
        listeners.setText(data.getListeners());
        Glide.with(itemView.getContext())
                .load(data.getUrl())
                .into(url);
    }
}
