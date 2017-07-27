package com.blikadek.popularmusic.pojo.Artist;

import com.blikadek.popularmusic.pojo.ArtistItemTopTrack;
import com.blikadek.popularmusic.pojo.ImageItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class ArtistItem {

    @SerializedName("name")
    private String nameA;
    @SerializedName("listeners")
    private String listenersA;
    @SerializedName("mbid")
    private String mbidA;
    @SerializedName("url")
    private String urlA;
    @SerializedName("image")
    private List<ImageItem> imageA;

    public ArtistItem() {

    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getListenersA() {
        return listenersA;
    }

    public void setListenersA(String listenersA) {
        this.listenersA = listenersA;
    }

    public String getMbidA() {
        return mbidA;
    }

    public void setMbidA(String mbidA) {
        this.mbidA = mbidA;
    }

    public String getUrlA() {
        return urlA;
    }

    public void setUrlA(String urlA) {
        this.urlA = urlA;
    }

    public List<ImageItem> getImageA() {
        return imageA;
    }

    public void setImageA(List<ImageItem> imageA) {
        this.imageA = imageA;
    }
}
