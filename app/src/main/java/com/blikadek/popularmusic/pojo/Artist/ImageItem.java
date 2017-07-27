package com.blikadek.popularmusic.pojo.Artist;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M13x5aY on 23/07/2017.
 */

public class ImageItem {
    @SerializedName("#text")
    private String texta;

    @SerializedName("size")
    private String sizea;

    public String getTexta() {
        return texta;
    }

    public void setTexta(String texta) {
        this.texta = texta;
    }

    public String getSizea() {
        return sizea;
    }

    public void setSizea(String sizea) {
        this.sizea = sizea;
    }
}
