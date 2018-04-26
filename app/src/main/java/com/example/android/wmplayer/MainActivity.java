package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    ArrayList<Author> authorDB;
    ArrayList<Song> songDB;
    MusicLibrary musicLibrary;
    Song nowPlayingSong;
    TextView nowPlayingTV;
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

        nowPlayingTV = findViewById(R.id.now_playing_tv);
        nowPlayingTV.setText(String.valueOf(authorDB.size()) + String.valueOf(authorDB.get(1).getSongsOfAuthor().size()));

        AuthorListAdapter authorListAdapter = new AuthorListAdapter(this, authorDB, new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(MainActivity.this, SongListActivity.class);
                //put Author into Extra
                i.putExtra("author", authorDB.get(position));
//                i.putParcelableArrayListExtra("authorDB", authorDB.get(position).getSongsOfAuthor());
                i.putExtra("nPSong", nowPlayingSong);
                startActivity(i);
            }
        });
        GridView authorGridView = findViewById(R.id.authorlist_gv);
        authorGridView.setAdapter(authorListAdapter);

        if(nowPlayingSong == null) {
            nowPlayingTV.setVisibility(View.GONE);
        }
    }


}
