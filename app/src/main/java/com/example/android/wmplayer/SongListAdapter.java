package com.example.android.wmplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/23/2018.
 */

public class SongListAdapter extends ArrayAdapter<Song> {

    AuthorListAdapter.OnAuthorItemClickListener callback;
    public SongListAdapter(@NonNull Context context, @NonNull ArrayList<Song> songDB, AuthorListAdapter.OnAuthorItemClickListener callback) {
        super(context,0,songDB);
        this.callback = callback;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }
        Song currentSong = getItem(position);

        final TextView songTitle = listItemView.findViewById(R.id.song_list_item_tv);
        songTitle.setText(currentSong.getTitle());
      listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemClick(position);
//                songTitle.setText("one two three");
            }
        });

        return listItemView;
    }
}
