package com.example.android.wmplayer;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/21/2018.
 */

public class MusicLibrary {

    private final String TAG = "MusicLibrary.java";
    //ArrayList of all @Author
    private ArrayList<Author> authorDB;
    private Song nowPlayingSong;

    public MusicLibrary() {
        authorDB = new ArrayList<Author>();
    }

    public ArrayList<Author> getAuthorDB() {
        return authorDB;
    }

    public void addSong(String title, String authorName) {
        Song song = new Song(title, authorName);
        Log.v(TAG, "public void addSong(String title, String authorName):songBg.size(): " + totalNumberOfSongs());
        updateMusicLibrary(song);
    }

    public void addSong(Song song) {
        Log.v(TAG, "public void addSong(Song song):songBg.size(): " + totalNumberOfSongs());
        updateMusicLibrary(song);
    }

    private void updateMusicLibrary(Song song) {
        boolean isAuthor = false;
        int authorIndex;
        for (Author author : authorDB) {
            authorIndex = author.getAuthorIndex();
            Log.v(TAG, "updateMusicLibrary(Song song) authorIndex w pętli: " + authorIndex);
            //compare song's author with existing in the library
            if (song.getAuthor().toLowerCase().equals(author.getAuthorName().toLowerCase())) {
                authorDB.get(authorIndex).addSong(song);
                isAuthor = true;
                Log.v(TAG, "updateMusicLibrary(Song song) song added ");
                break;
            }
        }
        if (!isAuthor) {
            createAuthor(song);

        }

    }

    /*
     Create @author, assign it's id in MusicLibrary and add the author to @authorDB
     */
    private void createAuthor(Song song) {
        authorDB.add(new Author(song.getAuthor()));
        authorDB.get(authorDB.size()-1).addSong(song);
    }

    //TODO use it in MainActivity
    private int totalNumberOfSongs() {
        int total = 0;
        for (Author author : authorDB) {
            for (Song song : author.getSongsOfAuthor()) {
                total++;
            }
        }
        return total;
    }

    public Song getNowPlayingSong() {
        return nowPlayingSong;
    }

    public void setNowPlayingSong(Song nowPlayingSong) {
        this.nowPlayingSong = nowPlayingSong;
    }
}
