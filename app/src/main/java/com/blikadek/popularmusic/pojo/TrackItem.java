package com.blikadek.popularmusic.pojo;

/**
 * Created by M13x5aY on 10/07/2017.
 */

public class TrackItem {

    private String name;
    private String listeners;
    private String url;

    public TrackItem(){

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
