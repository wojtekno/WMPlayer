package com.example.android.wmplayer;

import android.util.Log;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Author {
    private final String TAG = "Author.java";
    private String authorName;
    private int authorIndex;
    private static int numberOfAuthors = 0;
    private int numberOfTracks;

    public Author(String name) {
        this.authorName = name;
        this.authorIndex = numberOfAuthors;
        numberOfAuthors++;
        Log.v(TAG, "public Author(String name):this.getAuthorIndex()): " + this.getAuthorIndex());
        Log.v(TAG, "public Author(String name):Author.getNumberOfAuthors(): " + Author.getNumberOfAuthors());
    }

    public String getAuthorName() {
        return authorName;
    }

    public static int getNumberOfAuthors() {
        return numberOfAuthors;
    }

    public int getAuthorIndex() {
        return authorIndex;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }
    public static void resetNumberOfAuthors(){
        numberOfAuthors = 0;
    }
}
