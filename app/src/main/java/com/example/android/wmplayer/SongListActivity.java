package com.example.android.wmplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        TextView testTV = (TextView) findViewById(R.id.now_playing_sl_tv);
        testTV.setText(String.valueOf(getIntent().getIntExtra("numberOfTracks", 0)));

        TextView name = (TextView) findViewById(R.id.test_tv);
        name.setText(getIntent().getStringExtra("name"));

    }
}
