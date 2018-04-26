package com.example.android.wmplayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Author implements Parcelable {
    private final String TAG = "Author.java";
    private String authorName;
    private int authorIndex;
    private ArrayList<Song> songsOfAuthor;

    public Author(String name) {
        this.authorName = name;
        songsOfAuthor = new ArrayList<Song>();
//        Log.v(TAG, "public Author(String name):this.getAuthorIndex()): " + this.getAuthorIndex());
    }

    protected Author(Parcel in) {
        authorName = in.readString();
        authorIndex = in.readInt();
        songsOfAuthor = in.createTypedArrayList(Song.CREATOR);

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


    public int getAuthorIndex() {
        return authorIndex;
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
        parcel.writeTypedList(songsOfAuthor);
//        parcel.writeInt(numberOfTracks);
    }
}
