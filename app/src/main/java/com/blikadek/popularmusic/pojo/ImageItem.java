package com.blikadek.popularmusic.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M13x5aY on 15/07/2017.
 */

public class ImageItem {

    @SerializedName("#text")
    private String text;

    @SerializedName("size")
    private String size;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
