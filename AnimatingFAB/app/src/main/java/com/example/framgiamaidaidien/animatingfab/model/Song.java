package com.example.framgiamaidaidien.animatingfab.model;

/**
 * Created by FRAMGIA\mai.dai.dien on 15/12/2016.
 */

public class Song {
    private String mName;
    private String mArtist;
    private int mThumbnail;

    public Song() {
    }

    public Song(String name, String artist, int thumbnail) {
        this.mName = name;
        this.mArtist = artist;
        this.mThumbnail = thumbnail;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}
