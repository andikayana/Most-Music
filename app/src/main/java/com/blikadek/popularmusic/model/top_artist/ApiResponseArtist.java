package com.blikadek.popularmusic.model.top_artist;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class ApiResponseArtist {
    @SerializedName("artists")
    private Artists artists;

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}
