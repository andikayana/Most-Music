package com.blikadek.popularmusic.pojo;

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
    @SerializedName("image")
    private List<ImageItem> image;

    @SerializedName("artist")
    private ArtistItem artistItem;

    public TrackItem(){
    }

    public ArtistItem getArtistItem() {
        return artistItem;
    }

    public void setArtistItem(ArtistItem artistItem) {
        this.artistItem = artistItem;
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

}
