package com.example.android.wmplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlayingNowActivity extends AppCompatActivity {
    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now);

        song = getIntent().getParcelableExtra("song");

        TextView author = findViewById(R.id.author_tv);
        author.setText(song.getAuthor());

        TextView title = findViewById(R.id.title_tv);
        title.setText(song.getTitle());

    }
}
