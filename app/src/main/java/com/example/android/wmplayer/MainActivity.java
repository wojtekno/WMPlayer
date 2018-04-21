package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Author> authorDB;
    ArrayList<Song> songDB;
    ArrayList<ArrayList<Song>> musicLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authorDB = new ArrayList<Author>();
        songDB = new ArrayList<Song>();
        songDB.add(new Song("It's my life", "BonJovi"));
        songDB.add(new Song("Enter Sandman", "Metallica"));
        songDB.add(new Song("Sweet Dreams"));
        musicLibrary = new ArrayList<ArrayList<Song>>();
        createMusicLibrary();


        authorDB.add(new Author("BonJovi", 13));
        authorDB.add(new Author("Republika"));

        AuthorListAdapter authorListAdapter = new AuthorListAdapter(this, authorDB, new AuthorListAdapter.OnAuthorItemClickListener() {

            //TODO implementować tu, czy w adapterze?  implement it here or in AuthorListAdapter?
            @Override
            public void onItemClick(int position, Author currentAuthor) {
                Toast.makeText(MainActivity.this, "Toast w MainActivity", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SongListActivity.class);
                i.putExtra("name", currentAuthor.getAuthorsName());
                i.putExtra("numberOfTracks", currentAuthor.getNumberOfTracks());
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

    private boolean createMusicLibrary() {
        for (Song song : songDB) {
            for (Author author : authorDB) {
                int id = author.getAuthorId();
                if (song.getAuthor().toLowerCase().equals(author.getAuthorsName().toLowerCase())) {
                    author.addSongToAuthor();
                    musicLibrary.get(id).add(song);
                    return true;
                }
            }
            createAuthor(song);
            return false;
        }
        return false;
    }

    private void createAuthor(Song song) {
        new Author(song.getAuthor());
        musicLibrary.add(new ArrayList<Song>());
        musicLibrary.get(Author.getAuthorId()).add(song);

    }


}
