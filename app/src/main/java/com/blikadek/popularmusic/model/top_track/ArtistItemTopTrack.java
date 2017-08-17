package com.blikadek.popularmusic.model.top_track;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M13x5aY on 15/07/2017.
 */

public class ArtistItemTopTrack {

    @SerializedName("name")
    private String nameArtist;

    @SerializedName("mbid")
    private String mbid;

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }
}
