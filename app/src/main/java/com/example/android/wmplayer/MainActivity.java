package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Author> authorDB;
    MusicLibrary musicLibrary;
    Song nowPlayingSong;
    private final String TAG = "MainActivity";
    private final String NPSONG = "NowPlayingSong";
    String testing;
    TextView nowPlayingTitleTV;
    TextView headerTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        musicLibrary = new MusicLibrary();
        musicLibrary.addSong(new Song("Call of Ktullu", "Metallica"));
        musicLibrary.addSong(new Song("It's my life", "BonJovi"));
        musicLibrary.addSong("Enter Sandman", "Metallica");
        musicLibrary.addSong(new Song("Sweet Dreams"));

        testing = String.valueOf(musicLibrary.totalNumberOfSongs());
        authorDB = musicLibrary.getAuthorDB();

        headerTV = findViewById(R.id.totatl_number_tv);
        headerTV.setText("Total: " + testing + " songs");
        nowPlayingTitleTV = findViewById(R.id.now_playing_title_tv);
        nowPlayingTitleTV.setVisibility(View.GONE);
        nowPlayingTitleTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayingNowActivity.class);
                intent.putExtra(NPSONG, nowPlayingSong);
                startActivity(intent);
                            }
        });

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
        ListView authorListView = findViewById(R.id.authorlist_gv);
        authorListView.setAdapter(authorListAdapter);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                nowPlayingSong = data.getParcelableExtra(NPSONG);
                nowPlayingTitleTV.setText("playing: " + nowPlayingSong.getTitle());
                nowPlayingTitleTV.setVisibility(View.VISIBLE);
            }
        }
    }

}
