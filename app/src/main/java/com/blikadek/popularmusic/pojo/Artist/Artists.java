package com.blikadek.popularmusic.pojo.Artist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class Artists {

    @SerializedName("artists")
    private List<ArtistItem> artists;

    public List<ArtistItem> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistItem> artists) {
        this.artists = artists;
    }
}
