package com.blikadek.popularmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blikadek.popularmusic.R;
import com.blikadek.popularmusic.model.top_track.TrackItem;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TopTrackAdapter extends RecyclerView.Adapter<TopTrackAdapter.TrackViewHolder> {

    private List<TrackItem> trackItemList;
    private TopTrackClickListener mTopTrackClickListener;

    public TopTrackAdapter(List<TrackItem> trackItem) {
        this.trackItemList = trackItem;
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_item, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, final int position) {
        holder.bind(trackItemList.get(position));
        holder.LLDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTopTrackClickListener != null){
                    mTopTrackClickListener.onItemTopTrackClicked(
                            trackItemList.get(position)
                    );
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return trackItemList.size();
    }

    public void setData(List<TrackItem> datas){
        this.trackItemList.clear();
        trackItemList.addAll(datas);
        notifyDataSetChanged();
    }

    public void setTrackItemClickListener(TopTrackClickListener clickListener){
        if (clickListener != null)
            mTopTrackClickListener = clickListener;
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvJudulTrack)
        TextView name;
        @BindView(R.id.tvListener)
        TextView listeners;
        @BindView(R.id.imgTrack)
        ImageView image;
        @BindView(R.id.tvArtist)
        TextView artist;
        @BindView(R.id.tvPlayCount) TextView playCount;
        @BindView(R.id.LLDetail)
        LinearLayout LLDetail;

        public TrackViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(TrackItem data) {
            artist.setText(data.getArtistItemTopTrack().getNameArtist());
            name.setText(data.getName());
            playCount.setText(data.getPlaycount()+ " Play");
            listeners.setText(data.getListeners() +" Listeners");
            Glide.with(itemView.getContext())
                    .load(data.getImage().get(2).getText())
                    .into(image);
        }
    }


}
