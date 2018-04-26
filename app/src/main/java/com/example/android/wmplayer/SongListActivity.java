package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//TODO how to pass Arraylists from MusicLibrary to this class?
public class SongListActivity extends AppCompatActivity {

    ArrayList<Song> songsOfAuthor;
    Song nowPlayingSong;
    String authorName;
    Author author;
    private final String TAG = "SongListActivity";
    private final String NPSONG = "NowPlayingSong";
    private TextView playingNowTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        nowPlayingSong = getIntent().getParcelableExtra(NPSONG);
        author = getIntent().getExtras().getParcelable("author");
        authorName = author.getAuthorName();
        songsOfAuthor = author.getSongsOfAuthor();
        Log.v(TAG, "author.getsongs.get1: " + authorName + songsOfAuthor.get(0).getTitle());
        Log.v(TAG, "ONCreate:nowPlayingSong: " + nowPlayingSong);

        ListView listView = findViewById(R.id.songlist_lv);

        playingNowTV = (TextView) findViewById(R.id.now_playing_title_tv);
        playingNowTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SongListActivity.this, PlayingNowActivity.class);
                i.putExtra(NPSONG, nowPlayingSong);
                startActivity(i);
            }
        });
        playingNowTV.setVisibility(View.GONE);
        if (nowPlayingSong != null) {
            playingNowTV.setText("playing: " + nowPlayingSong.getTitle());
            playingNowTV.setVisibility(View.VISIBLE);
        }

        TextView authorNameTV = findViewById(R.id.author_tv);
        authorNameTV.setText(authorName);

        TextView numberOfTracksTV = findViewById(R.id.number_of_tracks_tv);
        numberOfTracksTV.setText(String.valueOf(songsOfAuthor.size()));

        final SongListAdapter songListAdapter = new SongListAdapter(SongListActivity.this, author.getSongsOfAuthor(), new AuthorListAdapter.OnAuthorItemClickListener() {

            @Override
            public void onItemClick(int position) {
                nowPlayingSong = songsOfAuthor.get(position);
                Log.v(TAG, "OnClick:nowPlayingSong: " + nowPlayingSong);
                sendNPSongToMainActivity(nowPlayingSong);
                Intent i = new Intent(SongListActivity.this, PlayingNowActivity.class);
                i.putExtra(NPSONG, nowPlayingSong);
                startActivity(i);
                playingNowTV.setText("playing: " + nowPlayingSong.getTitle());
                playingNowTV.setVisibility(View.VISIBLE);

            }
        });

        listView.setAdapter(songListAdapter);
    }

    public void sendNPSongToMainActivity(Song nowPlayingSong) {
        Intent intent = new Intent();
        intent.putExtra(NPSONG, nowPlayingSong);
        setResult(RESULT_OK, intent);
    }


}
