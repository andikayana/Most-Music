package com.blikadek.popularmusic.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class ResponseAPI {

    @SerializedName("tracks")
    private Tracks tracks;

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString(){
        return
                "ResponseAPI{" +
                        "tracks = '" + tracks + '\'' +
                        "}";
    }

}
