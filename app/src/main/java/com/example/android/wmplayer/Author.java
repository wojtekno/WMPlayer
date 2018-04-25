package com.example.android.wmplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Author implements Parcelable {
    private final String TAG = "Author.java";
    private String authorName;
    private int authorIndex;
    private static int numberOfAuthors = 0;
    private int numberOfTracks;
    private ArrayList<Song> songsOfAuthor;

    public Author(String name) {
        this.authorName = name;
        this.authorIndex = numberOfAuthors;
        songsOfAuthor = new ArrayList<Song>();
        numberOfAuthors++;
        Log.v(TAG, "public Author(String name):this.getAuthorIndex()): " + this.getAuthorIndex());
        Log.v(TAG, "public Author(String name):Author.getNumberOfAuthors(): " + Author.getNumberOfAuthors());
    }

    protected Author(Parcel in) {
        authorName = in.readString();
        authorIndex = in.readInt();
        numberOfTracks = in.readInt();
            }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

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
        songsOfAuthor.add(song);
    }

    public Song getSong(int index) {
        return songsOfAuthor.get(index);
    }

    public ArrayList<Song> getSongsOfAuthor() {
        return songsOfAuthor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(authorName);
        parcel.writeInt(authorIndex);
        parcel.writeInt(numberOfTracks);
            }
}
