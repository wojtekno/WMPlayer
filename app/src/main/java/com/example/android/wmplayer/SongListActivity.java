package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//TODO how to pass Arraylists from MusicLibrary to this class?
public class SongListActivity extends AppCompatActivity {
    ArrayList<Song> authorSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        final int authorId = getIntent().getIntExtra("position", 0);
        authorSong = MusicLibrary.getMusicLibrary().get(authorId);

        ListView listView = findViewById(R.id.songlist_lv);

        TextView playingNow = (TextView) findViewById(R.id.now_playing_sl_tv);
        playingNow.setText(String.valueOf(getIntent().getIntExtra("numberOfTracks", 0)));

        final TextView name = (TextView) findViewById(R.id.test_tv);
        name.setText(getIntent().getStringExtra("name"));

        SongListAdapter songListAdapter = new SongListAdapter(SongListActivity.this, authorSong, new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                name.setText("juuupipipipipi");
                Intent i = new Intent(SongListActivity.this, PlayingNowActivity.class);
                i.putExtra("position",position);
                i.putExtra("authorId", authorId);
                startActivity(i);

            }
        });

        listView.setAdapter(songListAdapter);
    }
}
