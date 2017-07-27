package com.blikadek.popularmusic.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.pojo.Artist.ArtistItem;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class ArtistViewHolder extends RecyclerView.ViewHolder {

    //@BindView(R.id.tvListenerArtist)
   public TextView listeners;
   // @BindView(R.id.imgArtist)
   public ImageView image;
    //@BindView(R.id.tvNameArtist)
   public TextView name;

    public ArtistViewHolder(View itemView) {
        super(itemView);

        listeners = (TextView)itemView.findViewById(R.id.tvListenerArtist);
        image = (ImageView) itemView.findViewById(R.id.imgArtist);
        name = (TextView)itemView.findViewById(R.id.tvNameArtist);

        //ButterKnife.bind(this, itemView);
    }

    public void bind(ArtistItem data, int position){


        name.setText(data.getNameA());
        listeners.setText(data.getListenersA());
        Glide.with(itemView.getContext())
                .load(data.getImageA().get(2).getText())
                .into(image);
    }
}
