package com.example.android.wmplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayingNowActivity extends AppCompatActivity {
    ArrayList<Song> authorSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now);

        int songId = getIntent().getIntExtra("position", 0);
        int authorId = getIntent().getIntExtra("authorId", 0);
        authorSong = MusicLibrary.getAuthorDB().get(authorId).getSongOfAuthor();

        TextView author = findViewById(R.id.author_tv);
        author.setText(authorSong.get(0).getAuthor());

        TextView title = findViewById(R.id.title_tv);
        title.setText(authorSong.get(songId).getTitle());

    }
}
