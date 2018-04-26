package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//TODO how to pass Arraylists from MusicLibrary to this class?
public class SongListActivity extends AppCompatActivity {
    private final String TAG = "SongListActivity";
    ArrayList<Song> songsOfAuthor;
    String authorName;
    Author author;
    Song nowPlayingSOng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        nowPlayingSOng = getIntent().getParcelableExtra("nPSong");
        author = getIntent().getExtras().getParcelable("author");
        authorName = author.getAuthorName();
        songsOfAuthor = author.getSongsOfAuthor();
        Log.v(TAG, "author.getsongs.get1: " + authorName + songsOfAuthor.get(0).getTitle());

        ListView listView = findViewById(R.id.songlist_lv);

        TextView playingNow = (TextView) findViewById(R.id.now_playing_tv);
        playingNow.setText(String.valueOf(songsOfAuthor.size()));

        TextView authorNameTV = findViewById(R.id.author_tv);
        authorNameTV.setText(authorName);

        TextView numberOfTracksTV = findViewById(R.id.number_of_tracks_tv);
        numberOfTracksTV.setText(String.valueOf(songsOfAuthor.size()));

        final SongListAdapter songListAdapter = new SongListAdapter(SongListActivity.this, author.getSongsOfAuthor(), new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(SongListActivity.this, PlayingNowActivity.class);
                i.putExtra("song",songsOfAuthor.get(position));
                startActivity(i);

            }
        });

        listView.setAdapter(songListAdapter);
    }
}
