package com.blikadek.popularmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.model.top_artist.ArtistItem;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.ArtistViewHolder> {
    private static final String TAG = TopArtistAdapter.class.getSimpleName();
    private List<ArtistItem> artistItemList;
   // private TopArtistActivity topArtistActivity;

    public TopArtistAdapter(List<ArtistItem> artistItemList){
        this.artistItemList=artistItemList;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_item, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        holder.bind(artistItemList.get(position));
    }

    @Override
    public int getItemCount() {
      return artistItemList.size();
    }

    public void setData(List<ArtistItem> mArtistItemList) {
        this.artistItemList.clear();
        artistItemList.addAll(mArtistItemList);
        notifyDataSetChanged();
    }


    public class ArtistViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNameArtist)
        TextView tvNAmeArtist;
        @BindView(R.id.tvListenerArtist)
        TextView tvListenerArtist;
        @BindView(R.id.imgArtist)
        ImageView imgArtist;

        public ArtistViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(ArtistItem artistItem) {
            tvNAmeArtist.setText(artistItem.getNameA());
            //playCount.setText(artistItem.getPlaycount()+ " Play");
            tvListenerArtist.setText(artistItem.getListenersA() +" Listeners");
            Glide.with(itemView.getContext())
                    .load(artistItem.getImageA().get(2).getText())
                    .into(imgArtist);
        }
    }
}
