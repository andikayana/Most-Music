package com.blikadek.popularmusic.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

import static android.R.attr.name;

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
