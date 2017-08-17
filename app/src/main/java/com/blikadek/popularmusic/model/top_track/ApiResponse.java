package com.blikadek.popularmusic.model.top_track;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class ApiResponse {

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
                "ApiResponse{" +
                        "tracks = '" + tracks + '\'' +
                        "}";
    }

}
