package com.example.android.wmplayer;

import android.util.Log;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Author {
    private String authorsName;
    private static int authorId = 0;
    private int numberOfTracks;

    public Author(String name) {
        this.authorsName = name;
        this.authorId = authorId++;
        Log.v("Author", "print author's authorId: "+ authorId);
        this.numberOfTracks = 23;
    }

    public Author(String name, int numberOfTracks) {
        this.authorsName = name;
        this.numberOfTracks = numberOfTracks;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public static int getAuthorId() {
        return authorId;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void addSongToAuthor(){
        numberOfTracks++;
    }
}
