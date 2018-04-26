package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Author> authorDB;
    MusicLibrary musicLibrary;
    Song nowPlayingSong;
    private final String TAG = "MainActivity";
    private final String NPSONG = "NowPlayingSong";
    String testing;
    TextView nowPlayingTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testing = "onCreate";
        musicLibrary = new MusicLibrary();
        musicLibrary.addSong(new Song("Call of Ktullu", "Metallica"));
        musicLibrary.addSong(new Song("It's my life", "BonJovi"));
        musicLibrary.addSong("Enter Sandman", "Metallica");
        musicLibrary.addSong(new Song("Sweet Dreams"));

        authorDB = musicLibrary.getAuthorDB();

        nowPlayingTV = findViewById(R.id.now_playing_tv);
//        nowPlayingTV.setText(String.valueOf(musicLibrary.totalNumberOfSongs()));

        AuthorListAdapter authorListAdapter = new AuthorListAdapter(this, authorDB, new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(MainActivity.this, SongListActivity.class);
                //put Author into Extra
                i.putExtra("author", authorDB.get(position));
                if(nowPlayingSong != null) {
                    i.putExtra(NPSONG, nowPlayingSong);
                }
                startActivityForResult(i, 1);
//                startActivity(i);
            }
        });
        GridView authorGridView = findViewById(R.id.authorlist_gv);
        authorGridView.setAdapter(authorListAdapter);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                nowPlayingSong = data.getParcelableExtra(NPSONG);
                nowPlayingTV.setText(nowPlayingSong.getTitle());
            }
        }
    }

}
