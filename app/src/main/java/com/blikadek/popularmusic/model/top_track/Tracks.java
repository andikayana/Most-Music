package com.blikadek.popularmusic.model.top_track;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class Tracks {


    @SerializedName("track")
    private List<TrackItem> track;

    public List<TrackItem> getTrack() {
        return track;
    }

    public void setTrackItems(List<TrackItem> track) {
        this.track = track;
    }
}
