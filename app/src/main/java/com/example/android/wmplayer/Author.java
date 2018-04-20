package com.example.android.wmplayer;

import android.util.Log;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Author {
    private String authorsName;
    private static int id = 0;
    private int numberOfTracks;

    public Author(String name) {
        this.authorsName = name;
        this.id = id++;
        Log.v("Author", "print author's id: "+ id);
        this.numberOfTracks = 23;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public static int getId() {
        return id;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }
}
