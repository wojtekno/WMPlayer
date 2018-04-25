package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    ArrayList<Author> authorDB;
    ArrayList<Song> songDB;
    MusicLibrary musicLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicLibrary = new MusicLibrary();
        musicLibrary.addSong(new Song("Call of Ktullu", "Metallica"));
        musicLibrary.addSong(new Song("It's my life", "BonJovi"));
        musicLibrary.addSong("Enter Sandman", "Metallica");
        musicLibrary.addSong(new Song("Sweet Dreams"));

        authorDB = musicLibrary.getAuthorDB();
//        authorDB.add(new Author("BonJovi", 13));
//        authorDB.add(new Author("Republika"));
//        Log.v(TAG, "authorDB.get(0): " + authorDB.get(0).getAuthorIndex());
//        Log.v(TAG, "authorDB.get(1): " + authorDB.get(1).getAuthorIndex());
//        musicLibrary.updateMusicLibrary();
//        System.out.println(TAG);
//        for (Author author : authorDB) {
//            System.out.println(author.getAuthorName());
//        }
//        musicLibrary.printLibrary();


        AuthorListAdapter authorListAdapter = new AuthorListAdapter(this, authorDB, new AuthorListAdapter.OnAuthorItemClickListener() {

            //TODO implementować tu, czy w adapterze?  implement it here or in AuthorListAdapter?
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(MainActivity.this, "Toast w MainActivity", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SongListActivity.class);
                i.putExtra("name", authorDB.get(position).getAuthorName());
                i.putExtra("numberOfTracks", authorDB.get(position).getNumberOfTracks());
                i.putExtra("position", position);
                Log.v(TAG, "number of tracks: " + authorDB.get(position).getNumberOfTracks());
                startActivity(i);
            }
        });
        GridView authorGridView = findViewById(R.id.authorlist_gv);
        authorGridView.setAdapter(authorListAdapter);

        //how to findView from outside the activit??
//        TextView authorsListLayout = (TextView) findViewById(R.id.authors_name_tv);
//        authorsListLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "lala", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(MainActivity.this, SongListActivity.class);
//                startActivity(i);
//            }
//        });

    }


}
