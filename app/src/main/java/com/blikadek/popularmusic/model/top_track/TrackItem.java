package com.blikadek.popularmusic.model.top_track;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TrackItem {

    @SerializedName("name")
    private String name;
    @SerializedName("listeners")
    private String listeners;
    @SerializedName("playcount")
    private String playcount;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private List<ImageItem> image;

    @SerializedName("artist")
    private ArtistItemTopTrack artistItemTopTrack;

    public TrackItem(){
    }

    public ArtistItemTopTrack getArtistItemTopTrack() {
        return artistItemTopTrack;
    }

    public void setArtistItemTopTrack(ArtistItemTopTrack artistItemTopTrack) {
        this.artistItemTopTrack = artistItemTopTrack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public List<ImageItem> getImage() {
        return image;
    }

    public void setImage(List<ImageItem> image) {
        this.image = image;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public TrackItem fromJson(String newsJson){
        return new Gson().fromJson(newsJson, TrackItem.class);
    }
}
