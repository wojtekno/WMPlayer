package com.example.android.wmplayer;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Author {
    private final String TAG = "Author.java";
    private String authorName;
    private int authorIndex;
    private static int numberOfAuthors = 0;
    private int numberOfTracks;
    private ArrayList<Song> songOfAuthor;

    public Author(String name) {
        this.authorName = name;
        this.authorIndex = numberOfAuthors;
        songOfAuthor = new ArrayList<Song>();
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

    public static void resetNumberOfAuthors() {
        numberOfAuthors = 0;
    }

    public void addSong(Song song) {
        songOfAuthor.add(song);
    }

    public Song getSong(int index) {
        return songOfAuthor.get(index);
    }

    public ArrayList<Song> getSongOfAuthor() {
        return songOfAuthor;
    }
}
