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
    ArrayList<Song> authorSong;
    int authorId;
    String authorName;
    Author author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        author = getIntent().getExtras().getParcelable("author");
        authorName = author.getAuthorName();
        authorSong = getIntent().getParcelableArrayListExtra("authorDB");
        Log.v(TAG, "author name and song1: " + authorName + authorSong.get(0));
//        authorId = getIntent().getIntExtra("position", 0);
//        authorName = getIntent().getStringExtra("name");
//        authorSong = MusicLibrary.getAuthorDB().get(authorId).getSongsOfAuthor();

        ListView listView = findViewById(R.id.songlist_lv);

        TextView playingNow = (TextView) findViewById(R.id.now_playing_sl_tv);
        playingNow.setText(String.valueOf(getIntent().getIntExtra("numberOfTracks", 0)));

        TextView authorNameTV = findViewById(R.id.author_tv);
        authorNameTV.setText(authorName);

        TextView numberOfTracksTV = findViewById(R.id.number_of_tracks_tv);
        numberOfTracksTV.setText("13");

//        TextView name = (TextView) findViewById(R.id.test_tv);
//        name.setText(getIntent().getStringExtra("name"));

        SongListAdapter songListAdapter = new SongListAdapter(SongListActivity.this, authorSong, new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(SongListActivity.this, PlayingNowActivity.class);
                i.putExtra("song", authorSong.get(position));
//                i.putExtra("position", position);
//                i.putExtra("authorId", authorId);
                startActivity(i);

            }
        });

        listView.setAdapter(songListAdapter);
    }
}
