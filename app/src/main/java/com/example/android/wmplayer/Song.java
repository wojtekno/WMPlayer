package com.example.android.wmplayer;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Song {

    private String title;
    private String author;
    private double time;

    public Song(String title, String author, double time) {
        this.title = title;
        this.author = author;
        this.time = time;
        assignToAuthor();
    }

    private void assignToAuthor() {}

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getTime() {
        return time;
    }

}