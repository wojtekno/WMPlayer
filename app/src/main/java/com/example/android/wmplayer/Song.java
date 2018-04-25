package com.example.android.wmplayer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class Song implements Parcelable{

    private String title;
    private String author;
    private double time;

    public Song(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Song(String title) {
        this.title = title;
        this.author = "NoName";
    }


    protected Song(Parcel in) {
        title = in.readString();
        author = in.readString();
        time = in.readDouble();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeDouble(time);
    }
}
