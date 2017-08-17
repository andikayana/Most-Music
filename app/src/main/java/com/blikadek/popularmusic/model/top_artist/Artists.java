package com.blikadek.popularmusic.model.top_artist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class Artists {

    @SerializedName("artist")
    private List<ArtistItem> artist;

    public List<ArtistItem> getArtist() {
        return artist;
    }

    public void setArtists(List<ArtistItem> artist) {
        this.artist = artist;
    }
}
