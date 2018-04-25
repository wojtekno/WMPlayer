package com.example.android.wmplayer;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/21/2018.
 */

public class MusicLibrary {

    private final String TAG = "MusicLibrary.java";
    //ArrayList of all @Author
    private static ArrayList<Author> authorDB;
//    //ArrayList of all @Song
//    private static ArrayList<Song> songDB;
//    //Arraylist of ArrayLists of @Song matched with @Author
//    private static ArrayList<ArrayList<Song>> musicLibrary;

    public MusicLibrary() {
        authorDB = new ArrayList<Author>();
//        songDB = new ArrayList<Song>();
//        musicLibrary = new ArrayList<ArrayList<Song>>();
        Author.resetNumberOfAuthors();
//        updateMusicLibrary();
    }

    public static ArrayList<Author> getAuthorDB() {
        return authorDB;
    }

    public void addSong(String title, String authorName) {
        Song song = new Song(title, authorName);
//        songDB.add(song);
//        Log.v(TAG, "public void addSong(String title, String authorName):songBg.size(): " + songDB.size());
        updateMusicLibrary(song);
    }

    public void addSong(Song song) {
//        songDB.add(song);
//        Log.v(TAG, "public void addSong(Song song):songBg.size(): " + songDB.size());
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
//                author.setNumberOfTracks(musicLibrary.get(authorIndex).size());
                isAuthor = true;
                Log.v(TAG, "updateMusicLibrary(Song song) song added ");
                break;
            }
        }
        if (!isAuthor) {
            createAuthor(song);
//            musicLibrary.add(new ArrayList<Song>());
//            musicLibrary.get(Author.getNumberOfAuthors() - 1).add(song);
        }

    }

//    //TODO how shuld this look like?
//    /*
//    create MusicLibrary - put each @song of the same @author to the same ArrayList
//     */
//    private void updateMusicLibrary() {
//        int authorIndex;
//        for (Song song : songDB) {
//            boolean isAuthor = false;
//            for (Author author : authorDB) {
//                authorIndex = author.getAuthorIndex();
//                //compare song's author with existing in the library
//                if (song.getAuthor().toLowerCase().equals(author.getAuthorName().toLowerCase())) {
//                    musicLibrary.get(authorIndex).add(song);
//                    author.setNumberOfTracks(musicLibrary.get(authorIndex).size());
//                    isAuthor = true;
//                    break;
//                }
//            }
//            if (!isAuthor) {
//                createAuthor(song);
//
//            }
//        }
//    }

    /*
     Create @author, assign it's id in MusicLibrary and add the author to @authorDB
     */
    private void createAuthor(Song song) {
        int lastIndex;
        Log.v(TAG, "before: createAuthor(Song song): Author.getNumberOfAuthors(): " + Author.getNumberOfAuthors());
        authorDB.add(new Author(song.getAuthor()));
        lastIndex = Author.getNumberOfAuthors() - 1;
        authorDB.get(lastIndex).addSong(song);
//        musicLibrary.add(new ArrayList<Song>());
//        musicLibrary.get(lastIndex).add(song);
//        authorDB.get(lastIndex).setNumberOfTracks(musicLibrary.get(lastIndex).size());
        Log.v(TAG, "after: createAuthor(Song song): Author.getNumberOfAuthors(): " + Author.getNumberOfAuthors());
//        musicLibrary.add(new ArrayList<Song>());
//        musicLibrary.get(Author.getNumberOfAuthors() - 1).add(song);
//        updateNumberOftracks();
    }

//    public void printLibrary() {
//        System.out.println(TAG);
//        System.out.println(TAG);
//        for (Song author : songDB) {
//            System.out.println(author.getTitle());
//        }
//        for (Author author : authorDB) {
//            System.out.println(author.getAuthorName());
//        }
//    }

//    public static ArrayList<Song> getSongDB() {
//        return songDB;
//    }
//
//    public static  ArrayList<ArrayList<Song>> getMusicLibrary() {
//        return musicLibrary;
//    }
}
