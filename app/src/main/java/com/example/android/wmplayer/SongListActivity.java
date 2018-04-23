package com.example.android.wmplayer;

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

        int pos = getIntent().getIntExtra("pos", 0);
        authorSong = MusicLibrary.getMusicLibrary().get(pos);


        ListView listView = findViewById(R.id.songlist_lv);

        TextView testTV = (TextView) findViewById(R.id.now_playing_sl_tv);
        testTV.setText(String.valueOf(getIntent().getIntExtra("numberOfTracks", 0)));

        final TextView name = (TextView) findViewById(R.id.test_tv);
        name.setText(getIntent().getStringExtra("name"));

        SongListAdapter songListAdapter = new SongListAdapter(SongListActivity.this, authorSong, new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                name.setText("juuupipipipipi");

            }
        });

        listView.setAdapter(songListAdapter);
    }
}
